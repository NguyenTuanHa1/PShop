package dao;

import entity.Discount;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountDB extends DBTest {
    public Discount getDiscountByProductId(int productId) {
        String query = "select d.* from discount d\n"
                + "join product_discount pd on d.discountId = pd.discountId\n"
                + "where pd.productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Discount(rs.getInt(1),
                        rs.getFloat(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getBoolean(5));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Discount> getAllDiscount() {
        List<Discount> list = new ArrayList<>();
        String query = "SELECT * FROM discount";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Discount(rs.getInt(1),
                        rs.getFloat(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getBoolean(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public Discount getDiscountByIdProduct(int productId) {
        String query = "select d.* from discount d\n"
                + "join product_discount pd on d.discountId = pd.discountId\n"
                + "where pd.productId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Discount(rs.getInt(1),
                        rs.getFloat(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getBoolean(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean addDiscount(String discountPercentage, Date startDate, Date endDate, boolean status) {
        String query = "INSERT INTO discount (discountPercentage, startDate, endDate, status) VALUES (?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, discountPercentage);
            ps.setDate(2, startDate);
            ps.setDate(3, endDate);
            ps.setBoolean(4, status);
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
