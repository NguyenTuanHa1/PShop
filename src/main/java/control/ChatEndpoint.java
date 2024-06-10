package control;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ChatRoomDB;
import dao.DAO;
import dao.MessageDB;
import entity.ChatRoom;
import entity.Message;
import utils.JwtUtil;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat/{token}")
public class ChatEndpoint {
    private static final CopyOnWriteArraySet<ChatEndpoint> connections = new CopyOnWriteArraySet<>();
    private Session session;
    private int userID;

    @OnOpen
    public void start(Session session, @PathParam("token") String token) {
        this.userID = Integer.parseInt(Objects.requireNonNull(JwtUtil.validateToken(token)));
        if (this.userID == 0) {
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Invalid token"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        session.getUserProperties().put("userID", this.userID);
        this.session = session;
        connections.add(this);
    }

    @OnClose
    public void end() {
        connections.remove(this);
    }

    @OnMessage
    public void incoming(String message) {
        if (this.userID != (int) session.getUserProperties().get("userID")) {
            return;
        }
        ChatRoomDB chatRoomDB = new ChatRoomDB();
        MessageDB messageDB = new MessageDB();
        ChatRoom chatRoom = chatRoomDB.findChatRoomByUserId(this.userID);
        if (chatRoom == null) {
            chatRoom = chatRoomDB.createChatRoom(this.userID);
        } else {
            if (chatRoom.getAdmin().getUserID() == this.userID) {
            }


            if (messageDB.insertMessage(message, chatRoom.getChatRoomID(), this.userID)) {
                Message msg = new Message();
                msg.setContent(message);
                msg.setChatRoomID(chatRoom.getChatRoomID());
                msg.setSender(chatRoom.getUser().getName());
                msg.setTimestamp(new Timestamp(System.currentTimeMillis()));
                ObjectMapper mapper = new ObjectMapper();
                String json = "";
                try {
                    json = mapper.writeValueAsString(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    boolean checkUser = chatRoom.getUser().getUserID() == this.userID;
                    for (ChatEndpoint client : connections) {
                        if (checkUser) {
                            if (client.userID == chatRoom.getAdmin().getUserID()) {
                                client.session.getBasicRemote().sendText(json);
                                break;
                            }
                        } else {
                            if (client.userID == chatRoom.getUser().getUserID()) {
                                client.session.getBasicRemote().sendText(json);
                                break;
                            }
                        }
                    }
                    session.getBasicRemote().sendText(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
