/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class CheckPermission {

    public static boolean checkAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if(!Objects.equals(user.getTypeAccountName(), "admin")) {
                response.sendRedirect("/");
                return false;
            }
        } else {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    public static boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    public static boolean checkEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if(!Objects.equals(user.getTypeAccountName(), "employee")) {
                response.sendRedirect("/");
                return false;
            }
        } else {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    public static boolean checkManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if(!Objects.equals(user.getTypeAccountName(), "admin") && !Objects.equals(user.getTypeAccountName(), "employee")) {
                response.sendRedirect("/");
                return false;
            }
        } else {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
