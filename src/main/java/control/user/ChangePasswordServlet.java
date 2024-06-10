package control.user;

import dao.Authentication;
import dao.DAO;
import dao.UserDB;
import entity.User;
import utils.EncryptUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changePassword"})
public class ChangePasswordServlet extends HttpServlet {
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
        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        int id = user.getUserID();
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        UserDB userDB = new UserDB();
        User userInfo = userDB.findUserById(id);
        String hashPassword = EncryptUtils.encrypt(oldPassword);
        if (!userInfo.getPassword().equals(hashPassword)) {
            request.setAttribute("errorMessage", "Mật khẩu cũ không đúng!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (!newPassword.matches(passwordRegex)) {
            request.setAttribute("errorMessage", "Mật khẩu phải chứa ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Mật khẩu mới không khớp!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }
        Authentication authenticationDB = new Authentication();
        if (!authenticationDB.changePassword(id, newPassword)) {
            request.setAttribute("errorMessage", "Đổi mật khẩu thất bại!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }
        session.removeAttribute("user");
        response.sendRedirect("/login");
    }
}
