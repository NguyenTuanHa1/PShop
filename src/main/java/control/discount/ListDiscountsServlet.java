package control.discount;

import dao.DiscountDB;
import entity.Discount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listDiscounts")
public class ListDiscountsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscountDB discountDAO = new DiscountDB();
        List<Discount> discounts = discountDAO.getAllDiscount();
        request.setAttribute("discounts", discounts);
        request.getRequestDispatcher("listDiscount.jsp").forward(request, response);
    }
}
