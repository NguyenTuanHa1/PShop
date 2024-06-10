package control.admin;

import dao.BillDB;
import dao.DAO;
import dao.PaymentDB;
import dao.TransportDB;
import entity.Bill;
import entity.BillDetail;
import entity.Payment;
import entity.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editBillAdmin")
public class EditBillAdminServlet extends HttpServlet {
    TransportDB transportDB = new TransportDB();
    PaymentDB paymentDB = new PaymentDB();
    BillDB billDB = new BillDB();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Transport> transportList = transportDB.getAllTransport();
        List<Payment> paymentList = paymentDB.getAllPayment();
        request.setAttribute("transportList", transportList);
        request.setAttribute("paymentList", paymentList);
        request.getRequestDispatcher("editBillAdmin.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int billId = Integer.parseInt(request.getParameter("billId"));
        Bill bill = billDB.getBillById(billId);
        if (bill == null) {
            response.sendRedirect("listBillAdmin");
            return;
        }
        List<Transport> transportList = transportDB.getAllTransport();
        List<Payment> paymentList = paymentDB.getAllPayment();
        List<BillDetail> billDetailList = billDB.getBillDetailByBillId(billId);
        request.setAttribute("billInfo", bill);
        request.setAttribute("transportList", transportList);
        request.setAttribute("paymentList", paymentList);
        request.setAttribute("billDetailList", billDetailList);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int billId = Integer.parseInt(request.getParameter("billId"));
        Bill bill = billDB.getBillById(billId);
        if (bill == null) {
            response.sendRedirect("listBillAdmin");
            return;
        }
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String statusBill = request.getParameter("statusBill");
        String voucherCode = request.getParameter("voucherCode");
        float vat = Float.parseFloat(request.getParameter("vat"));
        int transportId = Integer.parseInt(request.getParameter("transportId"));
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        int total = Integer.parseInt(request.getParameter("totalPrice"));
        if (billDB.updateBillByAdmin(billId, userName, email, city, district, phone, address, note, statusBill, voucherCode, vat, transportId, paymentId, total)){
            response.sendRedirect("listBillAdmin");
            return;
        }
        request.setAttribute("error", "Cập nhật hóa đơn thất bại");
        List<BillDetail> billDetailList = billDB.getBillDetailByBillId(billId);
        request.setAttribute("billInfo", bill);

        request.setAttribute("billDetailList", billDetailList);
        processRequest(request, response);
    }
}
