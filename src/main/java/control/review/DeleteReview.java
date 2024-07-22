package control.review;

import dao.ReviewDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReview", urlPatterns = {"/deleteReview"})
public class DeleteReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        ReviewDB reviewDB = new ReviewDB();
        reviewDB.deleteReview(reviewId);
        response.sendRedirect("/listReview?productId=" + productId);
    }
}
