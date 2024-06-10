/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.authentication;

import dao.Authentication;
import dao.CartDB;
import dao.DAO;
import dao.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String re_pass = request.getParameter("repassword");
        String email = request.getParameter("email");
        if (name.trim().isEmpty()) {
            request.setAttribute("errorMsg", "Tên không được để trống!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        // Regex to check email format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            request.setAttribute("errorMsg", "Email không hợp lệ!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (!pass.matches(passwordRegex)) {
            request.setAttribute("errorMsg", "Mật khẩu phải chứa ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if(!pass.equals(re_pass)){
            request.setAttribute("errorMsg", "Mật khẩu không khớp!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        Authentication authenticationDB = new Authentication();
        UserDB userDB = new UserDB();
        CartDB cartDB = new CartDB();
        if(!authenticationDB.checkAccountIsExist(email)){
            authenticationDB.signup(name, pass, email);
            int userId = userDB.findUserByEmail(email).getUserID();
            cartDB.createCart(userId);
            request.setAttribute("successMsg", "Đăng ký thành công, vui lòng kiểm tra email để xác nhận tài khoản!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            request.setAttribute("errorMsg", "Tài khoản đã tồn tại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
