package control.admin;

import dao.ProductTypeDB;
import entity.TypeProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editProductType")
public class EditProductType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        int typeProductId = Integer.parseInt(request.getParameter("typeProductId"));
        ProductTypeDB typeProductDB = new ProductTypeDB();
        TypeProduct typeProduct = typeProductDB.findProductTypeByID(typeProductId);
        request.setAttribute("typeProduct", typeProduct);
        request.getRequestDispatcher("editProductType.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        int typeProductId = Integer.parseInt(request.getParameter("typeProductId"));
        String typeProductName = request.getParameter("typeProductName");
        String describeType = request.getParameter("describeType");
        ProductTypeDB typeProductDB = new ProductTypeDB();
        typeProductDB.updateProductType(typeProductId, typeProductName, describeType);
        response.sendRedirect("/list-product-type");
    }
}
