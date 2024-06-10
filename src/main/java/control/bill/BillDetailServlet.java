package control.bill;

import dao.BillDB;
import dao.DAO;
import entity.Bill;
import entity.BillDetail;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/billDetail")
public class BillDetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkLogin(request, response)) {
            return;
        }
        BillDB billDB = new BillDB();
        int billId = Integer.parseInt(request.getParameter("billId"));
        Bill bill = billDB.getBillById(billId);
        List<BillDetail> billDetailList = billDB.getBillDetailByBillId(billId);
        request.setAttribute("bill", bill);
        request.setAttribute("billDetailList", billDetailList);
        request.getRequestDispatcher("billDetail.jsp").forward(request, response);
    }
}
