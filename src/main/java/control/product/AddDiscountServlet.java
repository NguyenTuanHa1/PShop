package control.product;

import dao.DAO;
import dao.DiscountDB;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
@WebServlet("/addDiscount")
public class AddDiscountServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        request.getRequestDispatcher("/addDiscount.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkAdmin(req, resp)) {
            return;
        }
        String discountPercentage = req.getParameter("discountPercentage");

        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        boolean status = req.getParameter("status").equals("1");
        DiscountDB discountDB = new DiscountDB();
        if(discountDB.addDiscount(discountPercentage, startDate, endDate, status)) {
            req.setAttribute("successMessage", "Thêm khuyến mãi thành công");
        } else {
            req.setAttribute("errorMessage", "Thêm khuyến mãi thất bại");
        }
        processRequest(req, resp);
    }
}
