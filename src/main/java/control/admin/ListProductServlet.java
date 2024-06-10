package control.admin;

import dao.DAO;
import dao.ProductDB;
import entity.Product;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDB productDB = new ProductDB();
        List<Product> productList = productDB.getAllProduct();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("listProductAdmin.jsp").forward(request, response);
    }
}
