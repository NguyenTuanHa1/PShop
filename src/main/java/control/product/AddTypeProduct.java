package control.product;

import dao.DAO;
import dao.ProductTypeDB;
import entity.TypeProduct;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTypeProduct")
public class AddTypeProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("addTypeProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        TypeProduct typeProduct = new TypeProduct(request.getParameter("typeProductName"), request.getParameter("describeType"));
        if (typeProduct.getTypeProductName() == null || typeProduct.getTypeProductName().isEmpty()) {
            request.setAttribute("errorMessage", "Loại sản phẩm không được để trống!");
            request.getRequestDispatcher("addTypeProduct.jsp").forward(request, response);
            return;
        }
        ProductTypeDB productTypeDB = new ProductTypeDB();
        if (productTypeDB.addTypeProduct(typeProduct)) {
            request.setAttribute("successMessage", "Thêm loại sản phẩm thành công!");
        } else {
            request.setAttribute("errorMessage", "Thêm loại sản phẩm thất bại!");
        }
        request.getRequestDispatcher("addTypeProduct.jsp").forward(request, response);
    }
}
