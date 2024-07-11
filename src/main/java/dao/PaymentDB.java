package dao;

import entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDB extends DBTest{
    public PaymentDB() {
        super();
    }

    public void deletePayment(int paymentId) {
        String query = "delete from payment where paymentId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    public void updatePayment(int paymentId, String paymentName) {
        String query = "update payment set typePayment = ? where paymentId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, paymentName);
            ps.setInt(2, paymentId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public Payment getPaymentById(int paymentId) {
        String query = "select * from payment where paymentId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, paymentId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Payment(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Payment> getAllPayment() {
        List<Payment> list = new ArrayList<>();
        String query = "select * from payment";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Payment(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addPayment(String paymentName) {
        String query = "INSERT INTO payment (typePayment) VALUES (?)";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, paymentName);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

}
