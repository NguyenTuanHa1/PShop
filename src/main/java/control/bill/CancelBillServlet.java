package control.bill;

import dao.BillDB;
import dao.DAO;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancelBill")
public class CancelBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkLogin(request, response)) {
            return;
        }
        BillDB billDB = new BillDB();
        int billId = Integer.parseInt(request.getParameter("billId"));
        billDB.cancelBill(billId);
        response.sendRedirect("/bills");
    }
}
