package control.admin;

import dao.SizeDB;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list-size")
public class ListSize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        SizeDB sizeDB = new SizeDB();
        request.setAttribute("listSize", sizeDB.getAllSize());
        request.getRequestDispatcher("/listSize.jsp").forward(request, response);
    }
}
