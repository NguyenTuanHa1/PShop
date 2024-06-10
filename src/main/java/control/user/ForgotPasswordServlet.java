package control.user;

import dao.Authentication;
import dao.DAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgotPassword"})
public class ForgotPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String emailAddress = request.getParameter("email");

        Authentication dao = new Authentication();
        boolean checkUser = dao.checkUserByEmail(emailAddress);
        if (!checkUser) {
            request.setAttribute("errorMessage", "Không tìm thấy tài khoản với email này!");
        } else {
            if (dao.forgotPassword(emailAddress)){
                request.setAttribute("successMessage", "Mã khôi phục mật khẩu đã được gửi đến email của bạn!");
            } else {
                request.setAttribute("errorMessage", "Có lỗi xảy ra, vui lòng thử lại sau!");
            }
        }
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    }
}
