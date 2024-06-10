package control.admin;

import dao.DAO;
import dao.UserDB;
import entity.User;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blockUser")
public class BlockUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UserDB userDB = new UserDB();
        int userId = Integer.parseInt(request.getParameter("userID"));
        userDB.blockUser(userId);
        response.sendRedirect("/listUser");
    }
}
