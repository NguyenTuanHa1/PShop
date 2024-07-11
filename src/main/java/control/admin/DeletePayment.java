package control.admin;

import dao.PaymentDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePayment", urlPatterns = {"/deletePayment"})
public class DeletePayment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDB paymentDB = new PaymentDB();
        paymentDB.deletePayment(Integer.parseInt(request.getParameter("paymentId")));
        response.sendRedirect("listPayment");
    }
}
