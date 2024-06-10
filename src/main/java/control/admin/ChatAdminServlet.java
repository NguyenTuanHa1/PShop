package control.admin;

import dao.ChatRoomDB;
import dao.MessageDB;
import dao.ProductDB;
import entity.ChatRoom;
import entity.Product;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chatAdmin")
public class ChatAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        if (!CheckPermission.checkAdmin(request, response)) {
//            return;
//        }
        response.setContentType("text/html;charset=UTF-8");
        ChatRoomDB chatRoomDB = new ChatRoomDB();
        List<ChatRoom> chatRoomList = chatRoomDB.getAllChatRoom();
        request.setAttribute("chatRoomList", chatRoomList);
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("chatAdmin.jsp").forward(request, response);
    }
}
