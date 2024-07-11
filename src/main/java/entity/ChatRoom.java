package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
//    CREATE TABLE chat_rooms (
//            chatRoomID BIGINT AUTO_INCREMENT PRIMARY KEY,
//            status BOOLEAN DEFAULT TRUE,
//            createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//            userID BIGINT,
//            adminID BIGINT,
//            FOREIGN KEY (userID) REFERENCES users(userID),
//    FOREIGN KEY (adminID) REFERENCES users(userID)
//            );
    private int chatRoomID;
    private boolean status = true;
    private Timestamp createdAt;
    private User user;
    private User admin;
    private Set<Message> messages = new HashSet<>();
    private int userID;
    private int adminID;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public ChatRoom() {
    }

    public ChatRoom(int chatRoomID, boolean status, Timestamp createdAt, User user, User admin) {
        this.chatRoomID = chatRoomID;
        this.status = status;
        this.createdAt = createdAt;
        this.user = user;
        this.admin = admin;
    }

    public int getChatRoomID() {
        return chatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        this.chatRoomID = chatRoomID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
