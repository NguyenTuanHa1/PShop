package control.discount;

import dao.DiscountDB;
import entity.Discount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/editDiscount")
public class EditDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        DiscountDB discountDAO = new DiscountDB();
        Discount discount = discountDAO.getDiscountById(discountId);
        request.setAttribute("discount", discount);
        request.getRequestDispatcher("editDiscount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        float discountPercentage = Float.parseFloat(request.getParameter("discountPercentage"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        boolean status = request.getParameter("status") != null;

        Discount discount = new Discount(discountId, discountPercentage, startDate, endDate, status);
        DiscountDB discountDAO = new DiscountDB();
        discountDAO.updateDiscount(discount);

        response.sendRedirect("/listDiscounts");
    }
}
