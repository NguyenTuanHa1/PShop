package control.review;

import dao.ReviewDB;
import entity.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListReview", urlPatterns = {"/listReview"})
public class ListReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all reviews
        int productId = Integer.parseInt(request.getParameter("productId"));
        ReviewDB reviewDB = new ReviewDB();
        request.setAttribute("productId", productId);
        // Get all reviews of product
        List<Review> reviews = reviewDB.getAllReviewByProductId(productId);
        request.setAttribute("reviewList", reviews);
        request.getRequestDispatcher("listReview.jsp").forward(request, response);
    }
}
