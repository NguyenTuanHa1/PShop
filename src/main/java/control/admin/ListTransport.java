package control.admin;

import dao.TransportDB;
import entity.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-transport")
public class ListTransport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(!CheckPermission.checkAdmin(request, response)) return;
        TransportDB transportDB = new TransportDB();
        List<Transport> transportList = transportDB.getAllTransport();
        request.setAttribute("transportList", transportList);
        request.getRequestDispatcher("listTransport.jsp").forward(request, response);
    }
}
