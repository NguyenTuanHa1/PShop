package control.shipper;

import dao.ShipperDB;
import entity.Shipper;
import entity.ShipperBill;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AcceptShipping", urlPatterns = {"/acceptShipping"})
public class AcceptShipping extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        ShipperDB shipperDB = new ShipperDB();
        Shipper shipper = shipperDB.findShipperByUserId(user.getUserID());
        if (shipper == null) {
            response.sendRedirect("/logout");
            return;
        }
        shipperDB.acceptShipping(Integer.parseInt(request.getParameter("billID")), shipper.getShipperID());
        response.sendRedirect("listBillShipper");
    }
}
