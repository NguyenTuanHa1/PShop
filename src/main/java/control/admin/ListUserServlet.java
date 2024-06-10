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
import java.util.List;

@WebServlet("/listUser")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        UserDB userDB = new UserDB();
        List<User> listUser = userDB.getAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
    }
}
