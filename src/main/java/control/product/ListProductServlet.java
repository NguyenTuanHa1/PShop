package control.product;

import dao.DAO;
import dao.ProductDB;
import dao.ProductTypeDB;
import entity.Product;
import entity.TypeProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDB productDB = new ProductDB();
        ProductTypeDB productTypeDB = new ProductTypeDB();
        List<TypeProduct> listType = productTypeDB.getAllProductTypeWithQuantity();
        List<Product> listTopProduct = productDB.getTopProduct();

        request.setAttribute("listTopProduct", listTopProduct);
        request.setAttribute("listType", listType);
        if (request.getParameter("typeId") != null) {
            int type = Integer.parseInt(request.getParameter("typeId"));
            List<Product> list = productTypeDB.getProductTypeById(type);
            request.setAttribute("listProduct", list);
            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
            return;
        }
        List<Product> list = productDB.getAllProductWithDiscount();


        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);
    }
}
