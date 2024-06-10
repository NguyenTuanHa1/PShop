package control.payment;

import dao.DAO;
import dao.PaymentDB;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPayment")
public class AddPaymentServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addPayment.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String typePayment = request.getParameter("typePayment");
        PaymentDB paymentDB = new PaymentDB();
        if(paymentDB.addPayment(typePayment)){
            request.setAttribute("successMessage", "Thêm phương thức thanh toán thành công");
        }else{
            request.setAttribute("mess", "Thêm phương thức thanh toán thất bại");
        }
        processRequest(request, response);
    }
}
