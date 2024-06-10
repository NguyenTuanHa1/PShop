package control.authentication;

import dao.Authentication;
import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verify")
public class VerifyController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //b1 get user,pass from cookie
        String token = request.getParameter("token");
        Authentication authenticationDB = new Authentication();
        authenticationDB.verifyAccount(token);
        // Send message to user
        response.getWriter().write("Your account has been verified. Please login to continue.");
        // Redirect to login page
        response.sendRedirect("/");
    }
}
