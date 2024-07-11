package control.admin;

import dao.PaymentDB;
import entity.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListPayment", urlPatterns = {"/list-payment"})
public class ListPayment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDB paymentDB = new PaymentDB();
        List<Payment> listPayment = paymentDB.getAllPayment();
        request.setAttribute("listPayment", listPayment);
        request.getRequestDispatcher("listPayment.jsp").forward(request, response);
    }
}
