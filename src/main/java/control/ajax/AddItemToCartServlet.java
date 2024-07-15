package control.ajax;

import dao.CartDB;
import dao.DAO;
import dao.DiscountDB;
import dao.ProductDB;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addItemToCart")
public class AddItemToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try{
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductDB productDB = new ProductDB();
            CartDB cartDB = new CartDB();
            DiscountDB discountDB = new DiscountDB();
            Product product = productDB.getDetailProductById(productId);
            if (product == null) {
                response.getWriter().println("Không tìm thấy sản phẩm");
                return;
            }
            if (!product.isStatus()) {
                response.getWriter().println("Sản phẩm đã ngừng kinh doanh");
                return;
            }
            if (product.getQuantity() == 0) {
                response.getWriter().println("Sản phẩm đã hết hàng");
                return;
            }
            if (quantity <= 0) {
                response.getWriter().println("Số lượng sản phẩm không hợp lệ");
                return;
            }

            HttpSession session = request.getSession();
            List<CartProducts> listCart = (List<CartProducts>) session.getAttribute("cart");
            if (listCart == null) {
                listCart = new ArrayList<>();
            }
            for (CartProducts c : listCart) {
                if (c.getProduct().getProductId() == productId) {
                    if (c.getQuantity() + quantity > product.getQuantity()) {
                        response.getWriter().println("Số lượng sản phẩm trong giỏ hàng vượt quá số lượng sản phẩm còn lại");
                        return;
                    }
                }
            }
            for (CartProducts c : listCart) {
                if (c.getProduct().getProductId() == productId) {
                    c.setQuantity(c.getQuantity() + quantity);
                    session.setAttribute("cart", listCart);

                    response.getWriter().println("Thêm sản phẩm vào giỏ hàng thành công");
                    return;
                }
            }
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                int cartId = cartDB.getCart(user.getUserID()).getCartId();
                if(cartDB.checkProductInCart(cartId, productId)) {
                    cartDB.updateQuantityProductInCart(user.getUserID(), productId, quantity);
                }
                else {
                    cartDB.addProductToCart(user.getUserID(), productId, quantity);
                }
            }
            Discount discount = discountDB.getDiscountByProductId(productId);
            listCart.add(new CartProducts(product, discount, quantity));
            session.setAttribute("cart", listCart);
            response.getWriter().println("Thêm sản phẩm vào giỏ hàng thành công");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Có lỗi xảy ra");
        }
    }
}
