package control.cart;

import dao.DAO;
import dao.PaymentDB;
import dao.TransportDB;
import entity.CartProducts;
import entity.LocationData;
import service.CityService;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/processCheckOut")
public class ProcessCheckOutServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             {
        try{
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            List<CartProducts> listCartProducts = (List<CartProducts>) session.getAttribute("cart");

            // Check if cart is empty
            if (listCartProducts == null || listCartProducts.isEmpty()) {
                response.sendRedirect("/cart");
                return;
            }

            // Get the list of provinces and districts from the JSON file
            CityService cityService = new CityService();
            LocationData locationData = null;
            try {
                locationData = cityService.getVietnamLocations();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error appropriately, e.g., set an error message attribute
            }

            // Set the list of provinces and districts as request attributes
            request.setAttribute("provinces", locationData.getProvince());
            request.setAttribute("districts", locationData.getDistrict());

            // Forward to the checkOut.jsp page
            request.getRequestDispatcher("checkOut.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkLogin(request, response)) {
            return;
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkLogin(request, response)) {
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        TransportDB transportDB = new TransportDB();
        PaymentDB paymentDB = new PaymentDB();
        List<CartProducts> listCartProducts = (List<CartProducts>) session.getAttribute("cart");
        int total = 0;
        for (CartProducts c : listCartProducts) {
            if ( c.getProduct().getPriceAfterDiscount() == 0) {
                total += c.getProduct().getPriceProduct() * c.getQuantity();
            } else {
                total += c.getProduct().getPriceAfterDiscount() * c.getQuantity();
            }
        }
        request.setAttribute("totalPrice", total);
        String voucherCode = null;
        try {
            voucherCode = request.getParameter("voucherCode") == null ? null : request.getParameter("voucherCode");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("voucherCode", voucherCode);
        request.setAttribute("listTransport", transportDB.getAllTransport());
        request.setAttribute("listPayment", paymentDB.getAllPayment());
        processRequest(request, response);
    }
}
