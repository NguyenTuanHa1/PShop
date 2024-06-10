package control.ajax;

import dao.CartDB;
import dao.DAO;
import entity.CartProducts;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/changeQuantityCart")
public class ChangeQuantityCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        List<CartProducts> listCart = (List<CartProducts>) session.getAttribute("cart");
        if (listCart == null) {
            listCart = new ArrayList<>();
        }
        CartDB cartDB = new CartDB();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            int cartId = cartDB.getCart(user.getUserID()).getCartId();

            cartDB.updateQuantityProductInCart(cartId, productId, quantity);
        }
        for (CartProducts c : listCart) {
            if (c.getProduct().getProductId() == productId) {
                c.setQuantity(quantity);
                session.setAttribute("cart", listCart);
                response.getWriter().println("Thay đổi số lượng sản phẩm trong giỏ hàng thành công");
            }
        }
    }
}
