/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.authentication;

import dao.Authentication;
import dao.CartDB;
import dao.DAO;
import entity.Cart;
import entity.CartProducts;
import entity.Product;
import entity.User;
import utils.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //b1 get user,pass from cookie
        Cookie arr[] = request.getCookies();
        if(arr != null) {
            for(Cookie o : arr) {
                if(o.getName().equals("usernameCookie")) {
                    request.setAttribute("username", o.getValue());
                }
                if(o.getName().equals("passwordCookie")) {
                    request.setAttribute("password", o.getValue());
                }
            }
        }
        //b2: set user,pass to login form
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember =request.getParameter("remember");

        Authentication authenticationDB = new Authentication();
        CartDB cartDB = new CartDB();
        User user = authenticationDB.login(email, password);
        if (user == null) {
            request.setAttribute("errorMsgLogin", "Sai tên đăng nhập hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if(!user.isStatus() && user.getToken() != null) {
                request.setAttribute("errorMsgLogin", "Tài khoản chưa được kích hoạt!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            if (user.isBan()){
                request.setAttribute("errorMsgLogin", "Tài khoản của bạn đã bị khóa, vui lòng liên hệ admin để mở khóa!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            // Get cart items current
            HttpSession session = request.getSession();

            List<CartProducts> listCartCurrent = session.getAttribute("cart") != null ? (List<CartProducts>) session.getAttribute("cart") : new ArrayList<>();

            List<CartProducts> listCartProducts = cartDB.getCartItems(user.getUserID());
            if (listCartProducts == null) {
                listCartProducts = new ArrayList<>();
            }
            // Merge cart items
            for (CartProducts cartProduct : listCartCurrent) {
                boolean isExist = false;
                for (CartProducts cartProduct1 : listCartProducts) {
                    if (cartProduct.getProduct().getProductId() == cartProduct1.getProduct().getProductId()) {
                        cartProduct1.setQuantity(cartProduct1.getQuantity() + cartProduct.getQuantity());
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    listCartProducts.add(cartProduct);
                }
            }

            session.setAttribute("user", user);
            session.setAttribute("cart", listCartProducts);
            session.setMaxInactiveInterval(60*60*24);
            Cookie usernameCookie = new Cookie("usernameCookie", email);
            Cookie passwordCookie = new Cookie("passwordCookie", password);
            if(remember != null) {
                passwordCookie.setMaxAge(60*60*24);
            }else {
                passwordCookie.setMaxAge(0);
            }

            usernameCookie.setMaxAge(60*60*24*365);

            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            String token = JwtUtil.generateToken(String.valueOf(user.getUserID()));
            response.addCookie(new Cookie("token", token));
            response.setHeader("Authorization", token);
            session.setAttribute("token", token);
            response.sendRedirect("/");
        }
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
