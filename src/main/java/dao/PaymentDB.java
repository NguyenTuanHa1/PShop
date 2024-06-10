package dao;

import entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDB extends DBTest{
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
