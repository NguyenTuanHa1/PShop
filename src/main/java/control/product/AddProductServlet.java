package control.product;

import dao.*;
import entity.Product;
import entity.User;
import utils.CheckPermission;
import utils.FileUploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class AddProductServlet extends HttpServlet {
    // Add product
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        ProductTypeDB productTypeDB = new ProductTypeDB();
        TradeMarkDB tradeMarkDB = new TradeMarkDB();
        SizeDB sizeDB = new SizeDB();
        DiscountDB discountDB = new DiscountDB();
        request.setAttribute("listProductType", productTypeDB.getAllProductType());
        request.setAttribute("listTrademark", tradeMarkDB.getAllTrademark());
        request.setAttribute("listSize", sizeDB.getAllSize());
        request.setAttribute("listDiscount", discountDB.getAllDiscount());
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Product product = new Product();
        product.setProductName(request.getParameter("productName"));
        product.setPriceProduct(Integer.parseInt(request.getParameter("priceProduct")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setDescribeProduct(request.getParameter("describeProduct"));
        product.setTrademarkId(Integer.parseInt(request.getParameter("trademarkId")));
        product.setTypeProductId(Integer.parseInt(request.getParameter("productTypeId")));
        product.setSizeId(Integer.parseInt(request.getParameter("sizeId")));

        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            request.setAttribute("errorMessage", "Tên sản phẩm không được để trống!");
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            return;
        }
        if (product.getPriceProduct() <= 0) {
            request.setAttribute("errorMessage", "Giá sản phẩm phải lớn hơn 0!");
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            return;
        }

        if (product.getQuantity() <= 0) {
            request.setAttribute("errorMessage", "Số lượng sản phẩm phải lớn hơn 0!");
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            return;
        }

        if (product.getDescribeProduct() == null || product.getDescribeProduct().isEmpty()) {
            request.setAttribute("errorMessage", "Mô tả sản phẩm không được để trống!");
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            return;
        }

        if (request.getPart("img") == null || request.getPart("img1") == null || request.getPart("img2") == null || request.getPart("img3") == null) {
            request.setAttribute("errorMessage", "Hình ảnh sản phẩm không được để trống!");
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            return;
        } else {
            String img = FileUploadUtils.uploadFile(request, getServletContext(), request.getPart("img"), FileUploadUtils.getFileName(request.getPart("img")));
            String img1 = FileUploadUtils.uploadFile(request, getServletContext(), request.getPart("img1"), FileUploadUtils.getFileName(request.getPart("img1")));
            String img2 = FileUploadUtils.uploadFile(request, getServletContext(), request.getPart("img2"), FileUploadUtils.getFileName(request.getPart("img2")));
            String img3 = FileUploadUtils.uploadFile(request, getServletContext(), request.getPart("img3"), FileUploadUtils.getFileName(request.getPart("img3")));
            product.setImg(img);
            product.setImg1(img1);
            product.setImg2(img2);
            product.setImg3(img3);
        }

        ProductDB productDB = new ProductDB();
        if (productDB.addProduct(product)) {
            request.setAttribute("successMessage", "Thêm sản phẩm thành công!");
        } else {
            request.setAttribute("errorMessage", "Thêm sản phẩm thất bại!");
        }
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
    }
}
