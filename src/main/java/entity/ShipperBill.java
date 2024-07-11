package entity;

public class ShipperBill {
//    CREATE TABLE shipper_bills (
//            shipperBillID INT AUTO_INCREMENT PRIMARY KEY,
//            shipperID INT,
//            billID INT,
//            status BOOLEAN DEFAULT 0,
//            createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//            updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//            FOREIGN KEY (shipperID) REFERENCES shippers(shipperID),
//    FOREIGN KEY (billID) REFERENCES bill(billID)
//            );
    private int shipperBillID;
    private int shipperID;
    private int billID;
    private boolean status;
    private String createdDate;
    private String updatedDate;
    private Shipper shipper;
    private Bill bill;

    public int getShipperBillID() {
        return shipperBillID;
    }

    public void setShipperBillID(int shipperBillID) {
        this.shipperBillID = shipperBillID;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
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

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ShipperBill(int shipperBillID, int shipperID, int billID, boolean status, String createdDate, String updatedDate, Shipper shipper, Bill bill) {
        this.shipperBillID = shipperBillID;
        this.shipperID = shipperID;
        this.billID = billID;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.shipper = shipper;
        this.bill = bill;
    }

    public ShipperBill() {
    }
}
