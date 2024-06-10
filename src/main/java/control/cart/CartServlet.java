package control.cart;

import dao.DAO;
import entity.Cart;
import entity.CartProducts;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartProducts> listCartProducts = (List<CartProducts>) session.getAttribute("cart");
        if (listCartProducts == null) {
            listCartProducts = new ArrayList<>();
            session.setAttribute("cart", listCartProducts);
        }

        request.setAttribute("cart", listCartProducts);
        int total = 0;
        for (CartProducts c : listCartProducts) {
            if ( c.getProduct().getPriceAfterDiscount() == 0) {
                total += c.getProduct().getPriceProduct() * c.getQuantity();
            } else {
                total += c.getProduct().getPriceAfterDiscount() * c.getQuantity();
            }
        }
        request.setAttribute("totalPrice", total);

        request.getRequestDispatcher("detailCart.jsp").forward(request, response);


    }
}
