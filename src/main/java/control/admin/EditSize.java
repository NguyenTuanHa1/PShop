package control.admin;

import dao.SizeDB;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editSize")
public class EditSize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        SizeDB sizeDB = new SizeDB();
        request.setAttribute("listSize", sizeDB.getAllSize());
        request.getRequestDispatcher("/editSize.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) return;
        SizeDB sizeDB = new SizeDB();
        String sizeId = request.getParameter("sizeId");
        String sizeName = request.getParameter("sizeName");
        sizeDB.updateSize(sizeId, sizeName);
        response.sendRedirect(request.getContextPath() + "/list-size");
    }
}
