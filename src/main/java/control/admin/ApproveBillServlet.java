package control.admin;

import dao.BillDB;
import dao.DAO;
import dao.ProductDB;
import entity.Bill;
import entity.BillDetail;
import entity.User;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/approveBill")
public class ApproveBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkManager(request, response)) {
            return;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        BillDB billDB = new BillDB();
        ProductDB productDB = new ProductDB();
        int billId = Integer.parseInt(request.getParameter("billId"));
        Bill bill = billDB.getBillById(billId);
        bill.setStatusBill("Đã xác nhận");
        bill.setEmployeeId(user.getUserID());
        List<BillDetail> billDetailList = billDB.getBillDetailByBillId(billId);
//        for (BillDetail billDetail : billDetailList) {
//            int quantity = productDB.getProductQuantity(billDetail.getProductId());
//            productDB.updateProductQuantity(billDetail.getProductId(), quantity - billDetail.getQuantity());
//        }
        billDB.approveBill(bill);
        response.sendRedirect("listBillAdmin");
    }
}
