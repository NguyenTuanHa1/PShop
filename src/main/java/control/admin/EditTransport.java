package control.admin;

import dao.TransportDB;
import entity.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editTransport")
public class EditTransport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        int transportId = Integer.parseInt(request.getParameter("transportId"));
        TransportDB transportDB = new TransportDB();
        Transport transport = transportDB.getTransportById(transportId);
        request.setAttribute("transport", transport);
        request.getRequestDispatcher("editTransport.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int transportId = Integer.parseInt(request.getParameter("transportId"));
        String transportName = request.getParameter("transportName");
        int priceTransPort = Integer.parseInt(request.getParameter("priceTransPort"));
        String descriptionTransport = request.getParameter("descriptionTransport");
        Transport transport = new Transport(transportId, transportName, priceTransPort, descriptionTransport);
        TransportDB transportDB = new TransportDB();
        transportDB.updateTransport(transport);
        response.sendRedirect("/list-transport");
    }
}
