package control.discount;

import dao.DiscountDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDiscount")
public class DeleteDiscountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        DiscountDB discountDAO = new DiscountDB();
        discountDAO.deleteDiscount(discountId);
        response.sendRedirect("/listDiscounts");
    }
}
