package control.ajax;

import dao.CartDB;
import dao.DAO;
import entity.Cart;
import entity.CartProducts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/removeItemFromCart")
public class RemoveItemFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<CartProducts> listCartProducts = (List<CartProducts>) session.getAttribute("cart");
        if (listCartProducts == null) {
            listCartProducts = new ArrayList<>();
        }
        CartDB cartDB = new CartDB();
        cartDB.removeProductFromCart(productId);

        for (CartProducts c : listCartProducts) {
            if (c.getProduct().getProductId() == productId) {
                listCartProducts.remove(c);
                session.setAttribute("cart", listCartProducts);
                response.getWriter().println("Xóa sản phẩm khỏi giỏ hàng thành công");
                return;
            }
        }

    }
}
