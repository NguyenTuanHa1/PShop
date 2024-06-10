package control.bill;

import dao.BillDB;
import dao.DAO;
import entity.Bill;
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

@WebServlet("/bills")
public class ListBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkLogin(request, response)) {
            return;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        BillDB billDB = new BillDB();
        List<Bill> listBill = billDB.getUserBills(user.getUserID());
        request.setAttribute("listBill", listBill);
        request.getRequestDispatcher("listBill.jsp").forward(request, response);
    }
}
