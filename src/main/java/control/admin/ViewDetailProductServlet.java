package control.admin;

import dao.DAO;
import dao.ProductDB;
import dao.ReviewDB;
import entity.Product;
import entity.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewDetailProduct")
public class ViewDetailProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productID"));
        ProductDB productDB = new ProductDB();
        ReviewDB reviewDB = new ReviewDB();
        Product product = productDB.getProductById(productId);
        List<Review> listReview = reviewDB.getAllReviewByProductId(productId);
        request.setAttribute("product", product);
        request.setAttribute("listReview", listReview);
        request.getRequestDispatcher("detailProductAdmin.jsp").forward(request, response);
    }
}
