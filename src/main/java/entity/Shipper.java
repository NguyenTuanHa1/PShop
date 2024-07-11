package entity;

public class Shipper {
//    CREATE TABLE shippers (
//            shipperID INT AUTO_INCREMENT PRIMARY KEY,
//            userID INT,
//    description TEXT,
//    status BOOLEAN DEFAULT 0,
//    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    FOREIGN KEY (userID) REFERENCES users(userID)
//            );
    private int shipperID;
    private int userID;
    private String description;
    private boolean status;
    private String createdDate;
    private String updatedDate;
    private User shipper;

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getShipper() {
        return shipper;
    }

    public void setShipper(User shipper) {
        this.shipper = shipper;
    }
}
