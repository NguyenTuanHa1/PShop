package control.review;

import dao.ReviewDB;
import entity.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editReview")
public class EditReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productID"));
        int reviewId = Integer.parseInt(request.getParameter("reviewID"));
        ReviewDB reviewDB = new ReviewDB();
        Review review = reviewDB.getReviewById(reviewId);
        request.setAttribute("review", review);
        request.setAttribute("productID", productId);
        request.getRequestDispatcher("editReview.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productID"));
        int reviewId = Integer.parseInt(request.getParameter("reviewID"));
        String content = request.getParameter("content");
        int starQuantity = Integer.parseInt(request.getParameter("starQuantity"));
        ReviewDB reviewDB = new ReviewDB();
        reviewDB.updateReview(reviewId, content, starQuantity);
        response.sendRedirect("/viewDetailProduct?productID=" + productId);
    }
}
