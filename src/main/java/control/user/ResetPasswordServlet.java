package control.user;

import dao.Authentication;
import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/resetPassword"})
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String token = request.getParameter("token");
        Authentication dao = new Authentication();
        if (dao.checkToken(token)) {
            request.setAttribute("token", token);
        } else {
            request.setAttribute("errorMessage", "Token không hợp lệ!");
        }
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        Authentication dao = new Authentication();
        if (!dao.checkToken(token)) {
            request.setAttribute("errorMessage", "Token không hợp lệ!");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Mật khẩu không khớp!");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
        if (dao.resetPassword(token, password)) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra, vui lòng thử lại sau!");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        }
    }
}
