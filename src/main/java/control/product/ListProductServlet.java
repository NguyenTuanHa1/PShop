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
import java.util.ArrayList;
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
        List<Product> listTopProduct = productDB.getTopProduct(3);
        if (request.getParameter("lower") != null && request.getParameter("upper") != null) {
            int lower = Integer.parseInt(request.getParameter("lower"));
            int upper = Integer.parseInt(request.getParameter("upper"));
            List<Product> list = productDB.getProductByPriceRange(lower, upper);
            request.setAttribute("listProduct", list);
            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
            return;
        }

        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int offset = (page - 1) * 9;
        request.setAttribute("page", page);
        request.setAttribute("listTopProduct", listTopProduct);
        request.setAttribute("listType", listType);
        List<String> listValidSort = new ArrayList<>();
        listValidSort.add("createdDate");
        listValidSort.add("priceProduct");
        listValidSort.add("productName");
        String sort = request.getParameter("sort") == null ? "createdDate" : request.getParameter("sort");
        request.setAttribute("sort", sort);

        if (!listValidSort.contains(sort)) {
            sort = "createdDate";
        }
        String typeSort = request.getParameter("typeSort") == null ? "asc" : request.getParameter("typeSort");
        if (!typeSort.equals("asc") && !typeSort.equals("desc")) {
            typeSort = "asc";
        }
        request.setAttribute("typeSort", typeSort);

        if (request.getParameter("typeId") != null) {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            List<Product> list = productTypeDB.getProductTypeById(typeId, offset, sort, typeSort);
            int totalAll = productTypeDB.getTotalProductTypeById(typeId);
            request.setAttribute("totalPage", (int) Math.ceil((double) totalAll / 9));

            request.setAttribute("totalAll", totalAll);
            request.setAttribute("typeId", typeId);
            request.setAttribute("listProduct", list);
            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
            return;
        }
        List<Product> list = productDB.getAllProductWithDiscount(offset, sort, typeSort);
        int totalAll = productDB.getTotalProduct();
        request.setAttribute("totalAll", totalAll);
        request.setAttribute("totalPage", (int) Math.ceil((double) totalAll / 9));

        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);
    }
}
