package control.product;

import dao.DAO;
import dao.ProductDB;
import dao.ReviewDB;
import entity.Product;
import entity.Review;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/detailProduct")
public class DetailProductServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            int idProduct = Integer.parseInt(request.getParameter("id"));
            ProductDB productDB = new ProductDB();
            ReviewDB reviewDB = new ReviewDB();
            Product product = productDB.getDetailProductById(idProduct);
            if (product != null) {
                List<Product> listRelatedProduct = productDB.getRelatedProduct(product.getTypeProductId(), product.getProductId());
                List<Review> listReview = reviewDB.getAllReviewByProductId(idProduct);
                boolean checkUser = false;
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                if (user != null) {
                    if (productDB.checkUserBuyProduct(idProduct, user.getUserID())) {
                        checkUser = true;
                    }
                }

                request.setAttribute("checkUser", checkUser);
                request.setAttribute("product", product);
                request.setAttribute("listRelatedProduct", listRelatedProduct);
                request.setAttribute("listReview", listReview);
                request.getRequestDispatcher("detailProduct.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
}
