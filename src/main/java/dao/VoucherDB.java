package dao;

import entity.Voucher;

import java.util.ArrayList;
import java.util.List;

public class VoucherDB extends DBTest{
    public Voucher getVoucherByCode(String code) {
        String query = "SELECT * FROM voucher WHERE code = ? AND status = 1 AND startDate <= CURDATE() AND endDate >= CURDATE()";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Voucher(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getDate(10),
                        rs.getDate(11));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean addVoucher(Voucher voucher) {
        String query = "INSERT INTO voucher (code, value, typeSale, status, describeVoucher, maxSale, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, voucher.getCode());
            ps.setInt(2, voucher.getValue());
            ps.setBoolean(3, voucher.isTypeSale());
            ps.setBoolean(4, voucher.isStatus());
            ps.setString(5, voucher.getDescribeVoucher());
            ps.setInt(6, voucher.getMaxSale());
            ps.setDate(7, voucher.getStartDate());
            ps.setDate(8, voucher.getEndDate());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<Voucher> getAllVoucher() {
        List<Voucher> list = new ArrayList<>();
        String query = "SELECT * FROM voucher";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Voucher(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getDate(10),
                        rs.getDate(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean unactiveVoucher(int voucherId) {
        String query = "UPDATE voucher SET status = 0 WHERE voucherId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, voucherId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean activeVoucher(int voucherId) {
        String query = "UPDATE voucher SET status = 1 WHERE voucherId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, voucherId);
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
