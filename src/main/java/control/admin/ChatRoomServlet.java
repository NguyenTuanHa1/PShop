package control.admin;

import dao.ChatRoomDB;
import entity.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chatRoomsAdmin")
public class ChatRoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChatRoomDB chatRoomDAO = new ChatRoomDB();
        List<ChatRoom> chatRooms = chatRoomDAO.getAllChatRooms();

        request.setAttribute("chatRooms", chatRooms);
        request.getRequestDispatcher("/adminChatRooms.jsp").forward(request, response);
    }
}
