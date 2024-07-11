package control.bill;

import dao.BillDB;
import dao.DAO;
import dao.ProductDB;
import entity.BillDetail;
import entity.Product;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cancelBill")
public class CancelBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkLogin(request, response)) {
            return;
        }
        BillDB billDB = new BillDB();
        ProductDB productDB = new ProductDB();
        int billId = Integer.parseInt(request.getParameter("billId"));
        billDB.cancelBill(billId);
        List<BillDetail> billDetails = billDB.getBillDetailByBillId(billId);
        for (BillDetail billDetail : billDetails) {
            Product product = productDB.getProductById(billDetail.getProductId());
            productDB.updateProductQuantity(product.getProductId(), product.getQuantity() + billDetail.getQuantity());
        }
        response.sendRedirect("/bills");
    }
}
