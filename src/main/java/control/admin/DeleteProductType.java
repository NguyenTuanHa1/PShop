package control.admin;

import dao.ProductTypeDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProductType")
public class DeleteProductType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        int typeProductId = Integer.parseInt(request.getParameter("typeProductId"));
        ProductTypeDB typeProductDB = new ProductTypeDB();
        typeProductDB.deleteProductType(typeProductId);
        response.sendRedirect("/list-product-type");
    }
}
