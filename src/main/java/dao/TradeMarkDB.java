package dao;

import entity.Trademark;

import java.util.ArrayList;
import java.util.List;

public class TradeMarkDB extends DBTest{
    public List<Trademark> getAllTrademark() {
        List<Trademark> list = new ArrayList<>();
        String query = "select trademarkId, trademarkName, logo, descriptionTrademark from Trademark";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Trademark(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addTrademark(Trademark trademark) {
        String query = "INSERT INTO Trademark (trademarkName, logo, descriptionTrademark) VALUES (?, ?, ?)";
        try {
            openConnection();
            ps.setString(1, trademark.getTrademarkName());
            ps.setString(2, trademark.getLogo());
            ps.setString(3, trademark.getDescriptionTrademark());
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
