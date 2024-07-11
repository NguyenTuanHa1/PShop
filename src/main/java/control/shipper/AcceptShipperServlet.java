package control.shipper;

import dao.ShipperDB;
import dao.UserDB;
import entity.Shipper;
import entity.User;
import utils.CheckPermission;
import utils.EmailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AcceptShipperServlet", urlPatterns = {"/acceptShipper"})
public class AcceptShipperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkAdmin(request, response)) return;
        ShipperDB shipperDB = new ShipperDB();
        int shipperID = Integer.parseInt(request.getParameter("shipperID"));
        Shipper shipper = shipperDB.findShipperById(shipperID);
        shipper.setStatus(true);
        shipperDB.updateShipper(shipper);
        request.setAttribute("successMessage", "Chấp nhận shipper thành công");
        EmailUtils.sendEmail(shipper.getShipper().getEmail(), "Chấp nhận shipper", "Chúc mừng, bạn đã được chấp nhận làm shipper");
        UserDB userDB = new UserDB();
        User user = userDB.findUserById(shipper.getUserID());
        user.setTypeAccountId(4);
        userDB.updateUser(user);
        request.getRequestDispatcher("listShipper").forward(request, response);
    }
}
