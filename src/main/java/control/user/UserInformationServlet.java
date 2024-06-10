package control.user;

import dao.DAO;
import dao.UserDB;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "UserInformationServlet", urlPatterns = {"/information"})
public class UserInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        int id = user.getUserID();
        UserDB userDB = new UserDB();
        User userInfo = userDB.findUserById(id);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("userInfo.jsp").forward(request, response);
    }
}
