package control.bill;

import dao.*;
import entity.*;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addBill")
public class AddBillServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addBill.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        try{
            if (!CheckPermission.checkLogin(request, response)) {
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
                if ( c.getProduct().getPriceAfterDiscount() == 0) {
                    total += c.getProduct().getPriceProduct() * c.getQuantity();
                } else {
                    total += c.getProduct().getPriceAfterDiscount() * c.getQuantity();
                }
            }
            User user = (User) session.getAttribute("user");
            int userId = user.getUserID();
            String userName = request.getParameter("userName");
            if (userName.trim().isEmpty()) {
                request.setAttribute("errroMessage", "Tên người nhận không được để trống");
                processRequest(request, response);
                return;
            }

            String email = request.getParameter("email");
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!email.matches(emailRegex)) {
                request.setAttribute("errroMessage", "Email không hợp lệ");
                processRequest(request, response);
                return;
            }

            String city = request.getParameter("city");
            // Check city
            if (city.trim().isEmpty()) {
                request.setAttribute("errroMessage", "Thành phố không được để trống");
                processRequest(request, response);
                return;
            }
            String district = request.getParameter("district");
            // Check district
            if (district.trim().isEmpty()) {
                request.setAttribute("errroMessage", "Quận/Huyện không được để trống");
                processRequest(request, response);
                return;
            }
            String phone = request.getParameter("phone");
            String phoneRegex = "0\\d{9,10}";
            if (!phone.matches(phoneRegex)) {
                request.setAttribute("errroMessage", "Số điện thoại không hợp lệ");
                processRequest(request, response);
                return;
            }
            String address = request.getParameter("address");
            if (address.trim().isEmpty()) {
                request.setAttribute("errroMessage", "Địa chỉ không được để trống");
                processRequest(request, response);
                return;
            }
            String note = request.getParameter("note");
            String voucherCode = request.getParameter("voucherCode");
            int transportId = Integer.parseInt(request.getParameter("transportId"));
            // Check transport
            if (transportId == 0) {
                request.setAttribute("errroMessage", "Vui lòng chọn phương thức vận chuyển");
                processRequest(request, response);
                return;
            }
            int paymentId = Integer.parseInt(request.getParameter("paymentId"));
            // Check payment
            if (paymentId == 0) {
                request.setAttribute("errroMessage", "Vui lòng chọn phương thức thanh toán");
                processRequest(request, response);
                return;
            }
            Voucher voucher = voucherDB.getVoucherByCode(voucherCode);
            if (voucher != null) {
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
            if(billResult.getBillId() > 0){
                billDB.addBillDetail(listCartProducts, billResult.getBillId());
                cartDB.clearCart(userId);
                ProductDB productDB = new ProductDB();
                for (CartProducts c : listCartProducts) {
                    productDB.updateProductQuantity(c.getProduct().getProductId(), c.getProduct().getQuantity() - c.getQuantity());
                }
                response.sendRedirect("/bills");
                List<CartProducts> newListCartProducts = new ArrayList<>();
                session.setAttribute("cart", newListCartProducts);
            } else {
                request.setAttribute("errroMessage", "Thêm hóa đơn thất bại");
                processRequest(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
