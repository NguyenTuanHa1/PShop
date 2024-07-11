package entity;

import java.sql.Timestamp;

public class Message {

    private int messageID;
    private String content;
    private Timestamp timestamp;
    private ChatRoom chatRoom;
    private User user;

    private User sender;
    private int chatRoomID;

    public int getChatRoomID() {
        return chatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        this.chatRoomID = chatRoomID;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Message() {
    }

    public Message(int messageID, String content, Timestamp timestamp, ChatRoom chatRoom, User user) {
        this.messageID = messageID;
        this.content = content;
        this.timestamp = timestamp;
        this.chatRoom = chatRoom;
        this.user = user;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
