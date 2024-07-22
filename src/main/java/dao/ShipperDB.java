package dao;

import entity.Bill;
import entity.Shipper;
import entity.ShipperBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipperDB extends DBTest{
    public ShipperDB() {
        super();
    }


    public void insertShipper(Shipper shipper) {
        String query = "INSERT INTO shippers (userID, description, status, createdDate, updatedDate) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipper.getUserID());
            ps.setString(2, shipper.getDescription());
            ps.setBoolean(3, shipper.isStatus());
            ps.setString(4, shipper.getCreatedDate());
            ps.setString(5, shipper.getUpdatedDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public List<Shipper> getAllShippers() {
        List<Shipper> listShippers = new ArrayList<>();
        String query = "SELECT * FROM shippers";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Shipper shipper = new Shipper();
                    shipper.setShipperID(rs.getInt("shipperID"));
                    shipper.setUserID(rs.getInt("userID"));
                    shipper.setDescription(rs.getString("description"));
                    shipper.setStatus(rs.getBoolean("status"));
                    shipper.setCreatedDate(rs.getString("createdDate"));
                    shipper.setUpdatedDate(rs.getString("updatedDate"));
                    shipper.setShipper(new UserDB().findUserById(rs.getInt("userID")));
                    listShippers.add(shipper);
                }
            }
        } catch (SQLException e) {
            System.out.println(2);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listShippers;
    }


    public Shipper findShipperById(int shipper) {
        String query = "SELECT * FROM shippers WHERE shipperID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipper);
            rs = ps.executeQuery();
            if (rs.next()) {
                Shipper shipper1 = new Shipper();
                shipper1.setShipperID(rs.getInt("shipperID"));
                shipper1.setUserID(rs.getInt("userID"));
                shipper1.setDescription(rs.getString("description"));
                shipper1.setStatus(rs.getBoolean("status"));
                shipper1.setCreatedDate(rs.getString("createdDate"));
                shipper1.setUpdatedDate(rs.getString("updatedDate"));
                shipper1.setShipper(new UserDB().findUserById(rs.getInt("userID")));
                return shipper1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean addShipper(Shipper shipper) {
        String query = "INSERT INTO shippers (userID, description, status, createdDate, updatedDate) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipper.getUserID());
            ps.setString(2, shipper.getDescription());
            ps.setBoolean(3, shipper.isStatus());
            ps.setString(4, shipper.getCreatedDate());
            ps.setString(5, shipper.getUpdatedDate());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    public boolean updateShipper(Shipper shipper) {
        String query = "UPDATE shippers SET userID = ?, description = ?, status = ?, updatedDate = ? WHERE shipperID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipper.getUserID());
            ps.setString(2, shipper.getDescription());
            ps.setBoolean(3, shipper.isStatus());
            ps.setString(4, shipper.getUpdatedDate());
            ps.setInt(5, shipper.getShipperID());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    public boolean deleteShipper(int shipperID) {
        String query = "DELETE FROM shippers WHERE shipperID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipperID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    public Shipper findShipperByUserId(int userId) {
        String query = "SELECT * FROM shippers WHERE userID = ? AND status = 1";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Shipper shipper = new Shipper();
                shipper.setShipperID(rs.getInt("shipperID"));
                shipper.setUserID(rs.getInt("userID"));
                shipper.setDescription(rs.getString("description"));
                shipper.setStatus(rs.getBoolean("status"));
                shipper.setCreatedDate(rs.getString("createdDate"));
                shipper.setUpdatedDate(rs.getString("updatedDate"));
                shipper.setShipper(new UserDB().findUserById(rs.getInt("userID")));
                return shipper;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ShipperBill> getShipperBills(int shipperID) {
        List<ShipperBill> listShipperBills = new ArrayList<>();
        String query = "SELECT * FROM shipper_bills WHERE shipperID = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, shipperID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ShipperBill shipperBill = new ShipperBill();
                    shipperBill.setShipperBillID(rs.getInt("shipperBillID"));
                    shipperBill.setShipperID(rs.getInt("shipperID"));
                    shipperBill.setBillID(rs.getInt("billID"));
                    shipperBill.setStatus(rs.getBoolean("status"));
                    shipperBill.setCreatedDate(rs.getString("createdDate"));
                    shipperBill.setUpdatedDate(rs.getString("updatedDate"));
                    shipperBill.setShipper(findShipperById(rs.getInt("shipperID")));
                    shipperBill.setBill(new BillDB().getBillById(rs.getInt("billID")));
                    listShipperBills.add(shipperBill);
                }
            } catch (Exception e) {
                System.out.println("Error processing result set: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }

        System.out.println(listShipperBills.size());
        return listShipperBills;
    }

    public void acceptShipping(int billID, int shipperID) {
        String query = "INSERT INTO shipper_bills (shipperID, billID) VALUES (?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, shipperID);
            ps.setInt(2, billID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
}
