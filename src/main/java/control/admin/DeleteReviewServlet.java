//package control.admin;
//
//import dao.DAO;
//import dao.ReviewDB;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/deleteReview")
//public class DeleteReviewServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        int productId = Integer.parseInt(request.getParameter("productID"));
//        int reviewId = Integer.parseInt(request.getParameter("reviewID"));
//        ReviewDB reviewDB = new ReviewDB();
//        reviewDB.deleteReview(reviewId);
//        response.sendRedirect("/viewDetailProduct?productID=" + productId);
//    }
//}
