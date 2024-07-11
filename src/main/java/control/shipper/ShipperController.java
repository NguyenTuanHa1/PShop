package control.shipper;

import dao.ShipperDB;
import dao.UserDB;
import entity.Shipper;
import entity.User;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShipperController", urlPatterns = {"/shipper"})
public class ShipperController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkLogin(request, response)) return;
        request.getRequestDispatcher("shipper.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(!CheckPermission.checkLogin(request, response)) return;
        ShipperDB shipperDB = new ShipperDB();
        UserDB userDB = new UserDB();
        int userID = Integer.parseInt(request.getParameter("userID"));
        User user = userDB.findUserById(userID);
        if(user.getAddress() == null || user.getPhoneNumber() == null || user.getEmail() == null) {
            request.setAttribute("errorMessage", "Hãy cập nhật thông tin cá nhân trước khi đăng ký làm shipper");
            request.getRequestDispatcher("shipper.jsp").forward(request, response);
            return;
        }
        String description = request.getParameter("description");
        Shipper shipper = new Shipper();
        shipper.setUserID(userID);
        shipper.setDescription(description);
        shipperDB.insertShipper(shipper);
        request.setAttribute("successMessage", "Đăng ký shipper thành công, vui lòng chờ xác nhận từ admin");
        request.getRequestDispatcher("shipper.jsp").forward(request, response);
    }
}
