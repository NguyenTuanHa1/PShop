package control.product;

import dao.DAO;
import dao.SizeDB;
import entity.Size;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addSize")
public class AddSizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("addSize.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Size size = new Size(request.getParameter("sizeName"), request.getParameter("describeSize"), request.getParameter("weight"));
        if (size.getSizeName() == null || size.getSizeName().isEmpty()) {
            request.setAttribute("errorMessage", "Kích thước không được để trống!");
            request.getRequestDispatcher("addSize.jsp").forward(request, response);
            return;
        }
        SizeDB sizeDB = new SizeDB();
        if (sizeDB.addSize(size)) {
            request.setAttribute("successMessage", "Thêm kích thước thành công!");
        } else {
            request.setAttribute("errorMessage", "Thêm kích thước thất bại!");
        }
        request.getRequestDispatcher("addSize.jsp").forward(request, response);
    }
}
