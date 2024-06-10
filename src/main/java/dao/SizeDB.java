package dao;

import entity.Size;

import java.util.ArrayList;
import java.util.List;

public class SizeDB extends DBTest{
    public List<Size> getAllSize() {
        List<Size> list = new ArrayList<>();
        String query = "select sizeId, sizeName, describeSize, weight from Size";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Size(rs.getInt(1),
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

    public boolean addSize(Size size) {
        String query = "INSERT INTO Size (sizeName, describeSize, weight) VALUES (?, ?, ?)";
        try {
            openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, size.getSizeName());
            ps.setString(2, size.getDescribeSize());
            ps.setString(3, size.getWeight());
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
