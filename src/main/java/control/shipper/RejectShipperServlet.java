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

@WebServlet(name = "RejectShipperServlet", urlPatterns = {"/rejectShipper"})
public class RejectShipperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkAdmin(request, response)) return;
        ShipperDB shipperDB = new ShipperDB();
        int shipperID = Integer.parseInt(request.getParameter("shipperID"));
        Shipper shipper = shipperDB.findShipperById(shipperID);
        shipper.setStatus(false);
        shipperDB.updateShipper(shipper);
        UserDB userDB = new UserDB();
        User user = userDB.findUserById(shipper.getUserID());
        user.setTypeAccountId(1);
        userDB.updateUser(user);
        request.setAttribute("successMessage", "Từ chối shipper thành công");
        EmailUtils.sendEmail(shipper.getShipper().getEmail(), "Từ chối shipper", "Xin lỗi, bạn đã bị từ chối làm shipper");
        request.getRequestDispatcher("listShipper").forward(request, response);
    }

}
