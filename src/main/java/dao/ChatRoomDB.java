package dao;

import entity.ChatRoom;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DBTest.closeConnection;

public class ChatRoomDB extends DBTest{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    private final UserDB userDB = new UserDB();


    public ChatRoom findChatRoomByID(int roomID) {
        String query = "SELECT * FROM chat_rooms WHERE chatRoomID = ?";
        return getChatRoom(roomID, query);
    }

    private ChatRoom getChatRoom(int roomID, String query) {
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, roomID);
            rs = ps.executeQuery();
            if (rs.next()) {
                ChatRoom chatRoom = new ChatRoom();
                chatRoom.setChatRoomID(rs.getInt("chatRoomID"));
                chatRoom.setStatus(rs.getBoolean("status"));
                chatRoom.setCreatedAt(rs.getTimestamp("createdAt"));
                User user = userDB.findUserById(rs.getInt("userID"));
                User admin = userDB.findUserById(1);
                chatRoom.setUser(user);
                chatRoom.setAdmin(admin);
                return chatRoom;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ChatRoom findChatRoomByUserId(int userID) {
        String query = "SELECT * FROM chat_rooms WHERE userID = ? and status = 1";
        return getChatRoom(userID, query);
    }

    public ChatRoom createChatRoom(int userID) {
        String query = "INSERT INTO chat_rooms (userID) VALUES ((SELECT userID FROM users WHERE userID = ?))";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.executeUpdate();
            return findChatRoomByUserId(userID);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ChatRoom findChatRoomByEmail(String email) {
        String query = "SELECT * FROM chat_rooms WHERE userID = (SELECT userID FROM users WHERE email = ?) and status = 1";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            System.out.println(email);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = userDB.findUserById( rs.getInt("userID"));
                User admin = userDB.findUserById(rs.getInt(5));
                return new ChatRoom(rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getTimestamp(3),
                        user,
                        admin);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    // getAllChatRooms
    public List<ChatRoom> getAllChatRooms() {
        List<ChatRoom> chatRooms = new ArrayList<>();
        String query = "SELECT cr.chatRoomID, cr.status, cr.createdAt, u1.userID AS userID, u1.name AS userName, u2.userID AS adminID, u2.name AS adminName " +
                "FROM chat_rooms cr " +
                "JOIN users u1 ON cr.userID = u1.userID " +
                "JOIN users u2 ON cr.adminID = u2.userID";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("userName"));

                User admin = new User();
                admin.setUserID(rs.getInt("adminID"));
                admin.setName(rs.getString("adminName"));

                ChatRoom chatRoom = new ChatRoom();
                chatRoom.setChatRoomID(rs.getInt("chatRoomID"));
                chatRoom.setStatus(rs.getBoolean("status"));
                chatRoom.setCreatedAt(rs.getTimestamp("createdAt"));
                chatRoom.setUser(user);
                chatRoom.setAdmin(admin);

                chatRooms.add(chatRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return chatRooms;
    }

    // getAllChatRoom
    public List<ChatRoom> getAllChatRoom() {
        List<ChatRoom> list = new ArrayList<>();
        String query = "select * from chat_rooms";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatRoom chatRoom = new ChatRoom();
                chatRoom.setChatRoomID(rs.getInt("chatRoomID"));
                chatRoom.setStatus(rs.getBoolean("status"));
                chatRoom.setCreatedAt(rs.getTimestamp("createdAt"));
                User user = userDB.findUserById(rs.getInt("userID"));
                User admin = userDB.findUserById(rs.getInt("adminID"));
                chatRoom.setUser(user);
                chatRoom.setAdmin(admin);
                list.add(chatRoom);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }
}
