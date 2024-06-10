package control.admin;

import dao.BillDB;
import dao.DAO;
import entity.Bill;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listBillAdmin")
public class ListBillAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkManager(request, response)) {
            return;
        }
        BillDB billDB = new BillDB();
        List<Bill> billList = billDB.getAllBill();
        request.setAttribute("billList", billList);
        request.getRequestDispatcher("listBillAdmin.jsp").forward(request, response);
    }
}
