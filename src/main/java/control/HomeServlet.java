package control;

import dao.ProductDB;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDB productDB = new ProductDB();
        List<Product> list = productDB.getTopProduct(6);
        req.setAttribute("listP", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
