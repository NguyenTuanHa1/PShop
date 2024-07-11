package control.admin;

import dao.PaymentDB;
import entity.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPayment", urlPatterns = {"/editPayment"})
public class EditPayment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDB paymentDB = new PaymentDB();
        Payment payment = paymentDB.getPaymentById(Integer.parseInt(request.getParameter("paymentId")));
        request.setAttribute("payment", payment);
        request.getRequestDispatcher("editPayment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDB paymentDB = new PaymentDB();
        paymentDB.updatePayment(Integer.parseInt(request.getParameter("paymentId")), request.getParameter("paymentName"));
        response.sendRedirect("listPayment");
    }
}
