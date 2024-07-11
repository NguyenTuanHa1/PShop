//package control;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import dao.ChatRoomDB;
//import dao.DAO;
//import dao.MessageDB;
//import dao.UserDB;
//import entity.ChatRoom;
//import entity.Message;
//import entity.User;
//import utils.JwtUtil;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.Objects;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@ServerEndpoint("/chatAdmin/{roomID}")
//public class ChatEndpointAdmin {
//    private static final CopyOnWriteArraySet<ChatEndpointAdmin> connections = new CopyOnWriteArraySet<>();
//    private Session session;
//    private int roomID;
//
//    @OnOpen
//    public void start(Session session, @PathParam("roomID") String roomId) {
//        this.roomID = Integer.parseInt(roomId);
//        session.getUserProperties().put("roomID", this.roomID);
//        this.session = session;
//        connections.add(this);
//    }
//
//    @OnClose
//    public void end() {
//        connections.remove(this);
//    }
//
//    @OnMessage
//    public void incoming(String message) throws IOException {
//
//        ChatRoomDB chatRoomDB = new ChatRoomDB();
//        MessageDB messageDB = new MessageDB();
//        ChatRoom chatRoom = chatRoomDB.findChatRoomByID(this.roomID);
//        if (chatRoom == null) {
//            session.getBasicRemote().sendText("Chat room not found");
//            return;
//        }
//
//
//            if (messageDB.insertMessage(message, chatRoom.getChatRoomID(), chatRoom.getAdmin().getUserID())) {
//                Message msg = new Message();
//                msg.setContent(message);
//                msg.setChatRoomID(chatRoom.getChatRoomID());
//                UserDB userDB = new UserDB();
//                User sender =
//                msg.setSender(chatRoom.getUser().getName());
//                msg.setTimestamp(new Timestamp(System.currentTimeMillis()));
//                ObjectMapper mapper = new ObjectMapper();
//                String json = "";
//                try {
//                    json = mapper.writeValueAsString(msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    for (ChatEndpointAdmin client : connections) {
//                            if (client.roomID != this.roomID) {
//                                client.session.getBasicRemote().sendText(json);
//                            }                    }
//                    session.getBasicRemote().sendText(json);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//    }
//}