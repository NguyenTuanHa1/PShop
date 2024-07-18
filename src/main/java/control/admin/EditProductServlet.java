package control.admin;

import dao.*;
import entity.*;
import utils.CheckPermission;
import utils.FileUploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/editProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DiscountDB discountDB = new DiscountDB();
        TradeMarkDB tradeMarkDB = new TradeMarkDB();
        SizeDB sizeDB = new SizeDB();
        ProductTypeDB productTypeDB = new ProductTypeDB();
        ProductDB productDB = new ProductDB();
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDB.getProductById(productId);
        List<TypeProduct> typeProductList = productTypeDB.getAllProductType();
        List<Size> sizeList = sizeDB.getAllSize();
        List<Trademark> trademarkList = tradeMarkDB.getAllTrademark();
        List<Discount> discountList = discountDB.getAllDiscount();
        Discount discount = discountDB.getDiscountByProductId(productId);
        request.setAttribute("product", product);
        request.setAttribute("typeProductList", typeProductList);
        request.setAttribute("sizeList", sizeList);
        request.setAttribute("trademarkList", trademarkList);
        request.setAttribute("discountList", discountList);
        request.setAttribute("discountProduct", discount);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDB productDB = new ProductDB();
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDB.getProductById(productId);
        if (FileUploadUtils.getFileName(request.getPart("img")).isEmpty() ||
                FileUploadUtils.getFileName(request.getPart("img1")).isEmpty() ||
                FileUploadUtils.getFileName(request.getPart("img2")).isEmpty() ||
                FileUploadUtils.getFileName(request.getPart("img3")).isEmpty()) {
            product.setImg(product.getImg());
            product.setImg1(product.getImg1());
            product.setImg2(product.getImg2());
            product.setImg3(product.getImg3());
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
        String productName = request.getParameter("productName");
        int priceProduct = Integer.parseInt(request.getParameter("priceProduct"));
        int typeProductId = Integer.parseInt(request.getParameter("typeProductId"));
        int sizeId = Integer.parseInt(request.getParameter("sizeId"));
        int trademarkId = Integer.parseInt(request.getParameter("trademarkId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String describeProduct = request.getParameter("describeProduct");
        boolean status = Objects.equals(request.getParameter("status"), "true");
        product.setProductName(productName);
        product.setPriceProduct(priceProduct);
        product.setTypeProductId(typeProductId);
        product.setSizeId(sizeId);
        product.setTrademarkId(trademarkId);
        product.setQuantity(quantity);
        product.setDescribeProduct(describeProduct);
        product.setStatus(status);
        productDB.editProduct(product);
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        boolean check = productDB.checkDiscountProduct(productId);
        if (check) {
            productDB.changeDiscountProduct(productId, discountId);
        } else {
            productDB.addDiscountProduct(productId, discountId);
        }
        response.sendRedirect("/listProduct");
    }
}
