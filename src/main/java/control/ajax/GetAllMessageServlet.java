package control.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ChatRoomDB;
import dao.DAO;
import dao.MessageDB;
import entity.ChatRoom;
import entity.Message;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getAllMessage")
public class GetAllMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.getWriter().print("[]");
            return;
        }
        ChatRoomDB chatRoomDB = new ChatRoomDB();

        ChatRoom chatRoom = chatRoomDB.findChatRoomByUserId(user.getUserID());
        MessageDB dao = new MessageDB();
        List<Message> list = dao.getAllMessageByChatRoomID(chatRoom.getChatRoomID());

        List<Message> listResult = new ArrayList<>();
        for (Message message : list) {
            Message message1 = new Message();
            message1.setMessageID(message.getMessageID());
            message1.setContent(message.getContent());
            message1.setTimestamp(message.getTimestamp());
            message1.setSender(message.getUser().getName());
            message1.setChatRoomID(message.getChatRoom().getChatRoomID());
            listResult.add(message1);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(listResult);
        resp.getWriter().print(json);

    }
}
