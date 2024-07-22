package dao;

import entity.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDB extends DBTest{
    public BillDB() {
        super();
    }

    public void confirmShipped(int billId, int shipperId) {
        String query = "UPDATE bill SET statusBill = 'Đã giao' WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public List<Bill> getAllBillToShipper() {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT b.*, t.transportName, p.typePayment FROM bill b\n"
                + "JOIN transport t ON b.transportId = t.transportId\n"
                + "JOIN payment p ON b.paymentId = p.paymentId\n"
                + "WHERE b.statusBill = 'Đã xác nhận' ORDER BY b.createdDate ASC";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getDate(17),
                        rs.getDate(18),
                        rs.getString(19),
                        rs.getString(20)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        System.out.println(list.size());
        return list;
    }

    public boolean buyAgain(int billID) {
        String query = "INSERT INTO bill (userId, userName, email, city, district, phone, address, note, voucherCode, transportId, paymentId, totalPrice) "
                + "SELECT userId, userName, email, city, district, phone, address, note, voucherCode, transportId, paymentId, totalPrice "
                + "FROM bill WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkQuantity(int billID) {
        String query = "SELECT bd.productId, bd.quantity, p.quantityProduct AS quantityInStock "
                + "FROM billDetail bd "
                + "JOIN products p ON bd.productId = p.productId "
                + "WHERE bd.billId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billID);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("quantity") > rs.getInt("quantityInStock")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public void addBillDetail(List<CartProducts> listCartProducts, int billId) {
        String query = "INSERT INTO billdetail (billId, productId, quantity, priceBillDetail) VALUES (?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            for (CartProducts c : listCartProducts) {
                ps.setInt(1, billId);
                ps.setInt(2, c.getProduct().getProductId());
                ps.setInt(3, c.getQuantity());
                if (c.getProduct().getPriceAfterDiscount() == 0) {
                    ps.setInt(4, c.getQuantity() * c.getProduct().getPriceProduct());
                } else {
                    ps.setInt(4, c.getQuantity() * c.getProduct().getPriceAfterDiscount());
                }
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Bill addBill(Bill bill) {
        String query = "INSERT INTO bill (userId, userName, email, city, district, phone, address, note, voucherCode, transportId, paymentId, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bill.getUserId());
            ps.setString(2, bill.getUserName());
            ps.setString(3, bill.getEmail());
            ps.setString(4, bill.getCity());
            ps.setString(5, bill.getDistrict());
            ps.setString(6, bill.getPhone());
            ps.setString(7, bill.getAddress());
            ps.setString(8, bill.getNote());
            ps.setString(9, bill.getVoucherCode());
            ps.setInt(10, bill.getTransportId());
            ps.setInt(11, bill.getPaymentId());
            ps.setInt(12, bill.getTotalPrice());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                bill.setBillId(rs.getInt(1));
            }
            return bill;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public Bill getBillById(int billId) {
        String query = "SELECT b.*, t.transportName, p.typePayment FROM bill b\n"
                + "JOIN transport t ON b.transportId = t.transportId\n"
                + "JOIN payment p ON b.paymentId = p.paymentId\n"
                + "JOIN users u ON b.userId = u.userId\n"
                + "WHERE b.billId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getDate(17),
                        rs.getDate(18),
                        rs.getString(19),
                        rs.getString(20));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<BillDetail> getBillDetailByBillId(int billId) {
        List<BillDetail> list = new ArrayList<>();
        String query = "SELECT p.*, "
                + "(p.priceProduct - (p.priceProduct * IFNULL(d.discountPercentage, 0) / 100)) AS priceAfterDiscount, "
                + "d.*, bd.* "
                + "FROM billDetail bd "
                + "JOIN products p ON bd.productId = p.productId "
                + "LEFT JOIN product_discount pd ON p.productId = pd.productId "
                + "LEFT JOIN discount d ON pd.discountId = d.discountId "
                + "WHERE bd.billId = ?";

        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getDate(13),
                        rs.getDate(14),
                        rs.getBoolean(15),
                        rs.getInt(16));
                Discount discount = new Discount(rs.getInt(17),
                        rs.getFloat(18),
                        rs.getDate(19),
                        rs.getDate(20),
                        rs.getBoolean(21));
                list.add(new BillDetail(rs.getInt("billDetailId"),
                        rs.getInt("productId"),
                        rs.getInt("billId"),
                        rs.getInt("quantity"),
                        rs.getInt("priceBillDetail"),
                        rs.getDate("createdDate"),
                        rs.getDate("updatedDate"),
                        product,
                        discount));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public void approveBill(Bill bill) {
        String query = "UPDATE bill SET statusBill = ?, employeeId = ? WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, bill.getStatusBill());
            ps.setInt(2, bill.getEmployeeId());
            ps.setInt(3, bill.getBillId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public boolean updateBillByAdmin(int billId, String userName, String email, String city, String district, String phone, String address, String note, String statusBill, String voucherCode, float vat, int transportId, int paymentId, int total) {
        String query = "UPDATE bill SET userName = ?, email = ?, city = ?, district = ?, phone = ?, address = ?, note = ?, statusBill = ?, voucherCode = ?, vat = ?, transportId = ?, paymentId = ?, totalPrice = ? WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, city);
            ps.setString(4, district);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, note);
            ps.setString(8, statusBill);
            ps.setString(9, voucherCode);
            ps.setFloat(10, vat);
            ps.setInt(11, transportId);
            ps.setInt(12, paymentId);
            ps.setInt(13, total);
            ps.setInt(14, billId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Bill> getAllBill(){
        List<Bill> list = new ArrayList<>();
        String query = "SELECT b.*, t.transportName, p.typePayment FROM bill b\n" +
                "JOIN transport t ON b.transportId = t.transportId\n" +
                "JOIN payment p ON b.paymentId = p.paymentId ORDER BY b.createdDate ASC";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getDate(17),
                        rs.getDate(18),
                        rs.getString(19),
                        rs.getString(20)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Bill> getUserBills(int userId) {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT b.*, t.transportName, p.typePayment FROM bill b\n"
                + "JOIN transport t ON b.transportId = t.transportId\n"
                + "JOIN payment p ON b.paymentId = p.paymentId\n"
                + "JOIN users u ON b.userId = u.userId\n"
                + "WHERE b.userId = ? ORDER BY b.createdDate ASC";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getDate(17),
                        rs.getDate(18),
                        rs.getString(19),
                        rs.getString(20)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public void deleteBillAdmin(int billId) {
        String deleteBillDetailQuery = "DELETE FROM billDetail WHERE billId = ?";

        String deleteBillQuery = "DELETE FROM bill WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(deleteBillDetailQuery);
            ps.setInt(1, billId);
            ps.executeUpdate();

            ps = conn.prepareStatement(deleteBillQuery);
            ps.setInt(1, billId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public boolean deleteBillDetailAdmin(int billDetailId) {
        String query = "DELETE FROM billDetail WHERE billDetailId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billDetailId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public void cancelBill(int billId) {
        String query = "UPDATE bill SET statusBill = 'Đã hủy' WHERE billId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
}
