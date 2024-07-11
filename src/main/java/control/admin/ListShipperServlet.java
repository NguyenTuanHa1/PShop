package control.admin;

import dao.ShipperDB;
import entity.Shipper;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListShipperServlet", urlPatterns = {"/listShipper"})
public class ListShipperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        if(!CheckPermission.checkLogin(request, response)) return;
        ShipperDB shipperDB = new ShipperDB();
        List<Shipper> listShippers = shipperDB.getAllShippers();
        request.setAttribute("listShippers", listShippers);
        request.getRequestDispatcher("listShipperAdmin.jsp").forward(request, response);
    }
}
