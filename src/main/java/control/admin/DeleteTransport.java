package control.admin;

import dao.TransportDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTransport")
public class DeleteTransport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkAdmin(request, response)) return;
        int transportId = Integer.parseInt(request.getParameter("transportId"));
        TransportDB transportDB = new TransportDB();
        transportDB.deleteTransport(transportId);
        response.sendRedirect("/list-transport");
    }
}
