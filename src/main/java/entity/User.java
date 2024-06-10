package entity;

import java.sql.Date;

public class User {
    private int userID;
    private String name;
    private Date userDOB;
    private boolean gender;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String avatar;
    private boolean status;
    private String description;
    private String idFacebook;
    private String idGoogle;
    private int typeAccountId;
    private String token;
    private Date createdAt;
    private Date updatedAt;

    public boolean isBan() {
        return isBan;
    }

    public void setBan(boolean ban) {
        isBan = ban;
    }

    private boolean isBan;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String typeAccountName;

    public String getTypeAccountName() {
        return typeAccountName;
    }

    public void setTypeAccountName(String typeAccountName) {
        this.typeAccountName = typeAccountName;
    }

    public User() {

    }

    public User(int userID, String name, Date userDOB, String password, String email, String phoneNumber, boolean gender, String address, String avatar, String description, int typeAccountId, String idFacebook, String idGoogle, boolean status, String token, Date createdAt, Date updatedAt, boolean isBan,String typeAccountName) {
        this.userID = userID;
        this.name = name;
        this.userDOB = userDOB;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatar = avatar;
        this.status = status;
        this.description = description;
        this.idFacebook = idFacebook;
        this.idGoogle = idGoogle;
        this.typeAccountId = typeAccountId;
        this.token = token;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isBan = isBan;
        this.typeAccountName = typeAccountName;
    }


    public User(int userID, String name, Date userDOB, String password, String email, String phoneNumber, boolean gender, String address, String avatar, String description, int typeAccountId, String idFacebook, String idGoogle, boolean status, String token, Date createdAt, Date updatedAt, boolean isBan) {
        this.userID = userID;
        this.name = name;
        this.userDOB = userDOB;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatar = avatar;
        this.status = status;
        this.description = description;
        this.idFacebook = idFacebook;
        this.idGoogle = idGoogle;
        this.typeAccountId = typeAccountId;
        this.token = token;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isBan = isBan;
    }

    public User(int userId, String userName, Date userDOB, String password, String email, String phone, boolean gender, String address, String avatarPath, String description, int typeAccountId, boolean status) {
        this.userID = userId;
        this.name = userName;
        this.userDOB = userDOB;
        this.password = password;
        this.email = email;
        this.phoneNumber = phone;
        this.gender = gender;
        this.address = address;
        this.avatar = avatarPath;
        this.description = description;
        this.typeAccountId = typeAccountId;
        this.status = status;
    }

    public User(String userName, Date userDOB, String password, String email, String phone, boolean gender, String address, String avatarPath, String description, int typeAccountId, boolean status) {
        this.name = userName;
        this.userDOB = userDOB;
        this.password = password;
        this.email = email;
        this.phoneNumber = phone;
        this.gender = gender;
        this.address = address;
        this.avatar = avatarPath;
        this.description = description;
        this.typeAccountId = typeAccountId;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(Date userDOB) {
        this.userDOB = userDOB;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(String idGoogle) {
        this.idGoogle = idGoogle;
    }

    public int getTypeAccountId() {
        return typeAccountId;
    }

    public void setTypeAccountId(int typeAccountId) {
        this.typeAccountId = typeAccountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", userDOB='" + userDOB + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", idFacebook='" + idFacebook + '\'' +
                ", idGoogle='" + idGoogle + '\'' +
                ", typeAccountId=" + typeAccountId +
                ", token='" + token + '\'' +
                '}';
    }


}
