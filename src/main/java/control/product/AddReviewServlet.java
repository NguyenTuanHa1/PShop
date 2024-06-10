package control.product;

import dao.DAO;
import dao.ReviewDB;
import entity.Review;
import entity.User;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addReview")
public class AddReviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkLogin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        String content = request.getParameter("content");
        if (content.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Nội dung đánh giá không được để trống!");
            response.sendRedirect("/detailProduct?id=" + productId);
            return;
        }
        int rating = Integer.parseInt(request.getParameter("startQuantity"));
        if (rating < 1 || rating > 5) {
            request.setAttribute("errorMessage", "Đánh giá phải từ 1 đến 5 sao!");
            response.sendRedirect("/detailProduct?id=" + productId);
            return;
        }
        ReviewDB reviewDB = new ReviewDB();
        Review review = new Review();
        review.setProductId(productId);
        review.setContent(content);
        review.setStarQuantity(rating);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        review.setUserId(user.getUserID());
        if (reviewDB.addReview(review)) {
            request.setAttribute("successMessage", "Thêm đánh giá thành công!");
        } else {
            request.setAttribute("errorMessage", "Thêm đánh giá thất bại!");
        }
        response.sendRedirect("/detailProduct?id=" + productId);
    }
}
