package control.transport;

import dao.DAO;
import dao.TransportDB;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTransport")
public class AddTransportServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("addTransport.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkAdmin(request, response)) return;
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String transportName = request.getParameter("transportName");
        int priceTransPort = Integer.parseInt(request.getParameter("priceTransPort"));
        String descriptionTransport = request.getParameter("descriptionTransport");
        if(TransportDB.addTransport(transportName, priceTransPort, descriptionTransport)){
            request.setAttribute("successMessage", "Thêm phương thức giao hàng thành công");
        }
        else{
            request.setAttribute("errorMessage", "Thêm phương thức giao hàng thất bại");
        }
        processRequest(request, response);
    }
}
