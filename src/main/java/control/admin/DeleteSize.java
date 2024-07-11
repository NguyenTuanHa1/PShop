package control.admin;

import dao.SizeDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSize", urlPatterns = {"/deleteSize"})
public class DeleteSize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SizeDB sizeDB = new SizeDB();
        sizeDB.deleteSize(Integer.parseInt(request.getParameter("sizeId")));
        response.sendRedirect("listSize");
    }
}
