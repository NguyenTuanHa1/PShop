package control.bill;

import com.google.gson.Gson;
import dao.*;
import entity.*;
import service.VNPayService;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addBill")
public class AddBillServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addBill.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> responseData = new HashMap<>();

        try {
            if (!CheckPermission.checkLogin(request, response)) {
                responseData.put("status", "error");
                responseData.put("message", "User not logged in");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            BillDB billDB = new BillDB();
            CartDB cartDB = new CartDB();
            TransportDB transportDB = new TransportDB();
            VoucherDB voucherDB = new VoucherDB();
            List<CartProducts> listCartProducts = (List<CartProducts>) session.getAttribute("cart");
            int total = 0;
            for (CartProducts c : listCartProducts) {
                if (c.getProduct().getPriceAfterDiscount() == 0) {
                    total += c.getProduct().getPriceProduct() * c.getQuantity();
                } else {
                    total += c.getProduct().getPriceAfterDiscount() * c.getQuantity();
                }
            }
            User user = (User) session.getAttribute("user");
            int userId = user.getUserID();
            String userName = request.getParameter("userName");
            if (userName.trim().isEmpty()) {
                responseData.put("status", "error");
                responseData.put("message", "Tên người nhận không được để trống");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String email = request.getParameter("email");
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!email.matches(emailRegex)) {
                responseData.put("status", "error");
                responseData.put("message", "Email không hợp lệ");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String city = request.getParameter("city");
            if (city.trim().isEmpty()) {
                responseData.put("status", "error");
                responseData.put("message", "Thành phố không được để trống");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String district = request.getParameter("district");
            if (district.trim().isEmpty()) {
                responseData.put("status", "error");
                responseData.put("message", "Quận/Huyện không được để trống");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String phone = request.getParameter("phone");
            String phoneRegex = "0\\d{9,10}";
            if (!phone.matches(phoneRegex)) {
                responseData.put("status", "error");
                responseData.put("message", "Số điện thoại không hợp lệ");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String address = request.getParameter("address");
            if (address.trim().isEmpty()) {
                responseData.put("status", "error");
                responseData.put("message", "Địa chỉ không được để trống");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            // Check city and district not null
            if (city.trim().isEmpty() || district.trim().isEmpty()) {
                responseData.put("status", "error");
                responseData.put("message", "Vui lòng chọn thành phố và quận/huyện");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            String note = request.getParameter("note");
            String voucherCode = request.getParameter("voucherCode");
            int transportId = Integer.parseInt(request.getParameter("transportId"));
            if (transportId == 0) {
                responseData.put("status", "error");
                responseData.put("message", "Vui lòng chọn phương thức vận chuyển");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            int paymentId = Integer.parseInt(request.getParameter("paymentId"));
            if (paymentId == 0) {
                responseData.put("status", "error");
                responseData.put("message", "Vui lòng chọn phương thức thanh toán");
                response.getWriter().write(new Gson().toJson(responseData));
                return;
            }

            ProductDB productDB = new ProductDB();
            for (CartProducts c : listCartProducts) {
                Product product = productDB.getProductById(c.getProduct().getProductId());
                if (c.getQuantity() > product.getQuantity()) {
                    responseData.put("status", "error");
                    responseData.put("message", "Số lượng sản phẩm " + product.getProductName() + " không đủ");
                    response.getWriter().write(new Gson().toJson(responseData));
                    return;
                }
            }

            Voucher voucher = new Voucher();
            if (voucherCode != null && !voucherCode.trim().isEmpty()) {
                voucher = voucherDB.getVoucherByCode(voucherCode);
                if (voucher == null) {
                    responseData.put("status", "error");
                    responseData.put("message", "Mã giảm giá không hợp lệ");
                    response.getWriter().write(new Gson().toJson(responseData));
                    return;
                }
                if (voucher.getEndDate().getTime() < System.currentTimeMillis()) {
                    responseData.put("status", "error");
                    responseData.put("message", "Mã giảm giá đã hết hạn");
                    response.getWriter().write(new Gson().toJson(responseData));
                    return;
                }
            } else {
                voucherCode = null;
            }
            if (voucher.getVoucherId() > 0) {
                int discountValue = 0;
                if (voucher.isTypeSale()) {
                    discountValue = total * voucher.getValue() / 100;
                } else {
                    discountValue = voucher.getValue();
                }
                if (discountValue > voucher.getMaxSale()) {
                    discountValue = voucher.getMaxSale();
                }
                total -= discountValue;
            }

            Transport transport = transportDB.getTransportById(transportId);
            total += transport.getPriceTransPort();

            Bill bill = new Bill(userId, userName, email, city, district, phone, address, note, voucherCode, transportId, paymentId, total);
            Bill billResult = billDB.addBill(bill);
            if (billResult != null && billResult.getBillId() > 0) {
                billDB.addBillDetail(listCartProducts, billResult.getBillId());
                cartDB.clearCart(userId);
                for (CartProducts c : listCartProducts) {
                    productDB.updateProductQuantity(c.getProduct().getProductId(), c.getProduct().getQuantity() - c.getQuantity());
                }
                List<CartProducts> newListCartProducts = new ArrayList<>();
                session.setAttribute("cart", newListCartProducts);
                if (paymentId == 1) {
                    VNPayService vnpayService = new VNPayService();
                    String vnpayUrl = vnpayService.getRequest(String.valueOf(total), "", "vn", "VND", request);
                    responseData.put("status", "success");
                    responseData.put("redirectUrl", vnpayUrl);
                } else {
                    responseData.put("status", "success");
                    responseData.put("redirectUrl", "/bills");
                }
                response.getWriter().write(new Gson().toJson(responseData));
            } else {
                responseData.put("status", "error");
                responseData.put("message", "Thêm hóa đơn thất bại");
                response.getWriter().write(new Gson().toJson(responseData));
            }
        } catch (Exception e) {
            responseData.put("status", "error");
            responseData.put("message", e.getMessage());
            response.getWriter().write(new Gson().toJson(responseData));
            e.printStackTrace();
        }
    }
}
