/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;
import utils.EmailUtils;
import utils.EncryptUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;






    public boolean updateVoucher(Voucher voucher) {
        String query = "UPDATE voucher SET code = ?, value = ?, typeSale = ?, status = ?, describeVoucher = ?, maxSale = ?, startDate = ?, endDate = ? WHERE voucherId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, voucher.getCode());
            ps.setInt(2, voucher.getValue());
            ps.setBoolean(3, voucher.isTypeSale());
            ps.setBoolean(4, voucher.isStatus());
            ps.setString(5, voucher.getDescribeVoucher());
            ps.setInt(6, voucher.getMaxSale());
            ps.setDate(7, voucher.getStartDate());
            ps.setDate(8, voucher.getEndDate());
            ps.setInt(9, voucher.getVoucherId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public Voucher getVoucherById(int voucherId) {
        String query = "SELECT * FROM voucher WHERE voucherId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, voucherId);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        }
        return null;
    }
    public boolean deleteVoucher(int voucherId) {
        String query = "DELETE FROM voucher WHERE voucherId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, voucherId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }













































    // =============================== Start Product ===========================================
































        // =============================== End Product ===========================================

    // =============================== Start Authen ===========================================














    // =============================== End Authen ===========================================
}
