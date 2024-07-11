package control.admin;

import dao.ProductTypeDB;
import entity.TypeProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-product-type")
public class ListProductType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        ProductTypeDB typeProductDB = new ProductTypeDB();
        List<TypeProduct> typeProducts = typeProductDB.getAllProductType();
        request.setAttribute("typeProducts", typeProducts);
        request.getRequestDispatcher("listProductType.jsp").forward(request, response);
    }
}
