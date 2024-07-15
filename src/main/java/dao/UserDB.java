package dao;

import entity.TypeAccount;
import entity.User;
import utils.EncryptUtils;

import java.util.ArrayList;
import java.util.List;

import static dao.DBConnection.closeConnection;

public class UserDB extends DBTest {

    public UserDB() {
        super();
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET name = ?, userDOB = ?, email = ?, phoneNumber = ?, gender = ?, address = ?, avatar = ?, status = ?, description = ?, typeAccountId = ? WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setDate(2, user.getUserDOB());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setBoolean(5, user.isGender());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getAvatar());
            ps.setBoolean(8, user.isStatus());
            ps.setString(9, user.getDescription());
            ps.setInt(10, user.getTypeAccountId());
            ps.setInt(11, user.getUserID());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public User findUserById(int id) {
        String query = "SELECT u.*, t.typeAccountName " +
                "FROM users u " +
                "JOIN typeAccount t ON u.typeAccountId = t.typeAccountId " +
                "WHERE u.userID = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18),
                        rs.getString(19));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public User findUserByGoogleId(String googleId) {
        String query = "SELECT * FROM users WHERE idGoogle = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, googleId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public User findUserByFBId(String fbId)  {
        String query = "SELECT * FROM users WHERE idFacebook = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, fbId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public User findUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean editInfoUser(User user) {
        String query = "UPDATE users SET name = ?, userDOB = ?, email = ?, phoneNumber = ?, gender = ?, address = ?, description = ?, avatar = ? WHERE userID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setDate(2, user.getUserDOB());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setBoolean(5, user.isGender());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getDescription());
            ps.setString(8, user.getAvatar());
            ps.setInt(9, user.getUserID());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String query = "SELECT u.*, ta.typeAccountName FROM users u\n"
                + "JOIN typeaccount ta ON u.typeAccountId = ta.typeAccountId";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18),
                        rs.getString(19)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<TypeAccount> getAllTypeAccount() {
        List<TypeAccount> list = new ArrayList<>();
        String query = "SELECT * FROM typeaccount";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TypeAccount(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateUserByAdmin(User user) {
        String query = "UPDATE users SET name = ?, userDOB = ?, email = ?, phoneNumber = ?, gender = ?, address = ?, avatar = ?, status = ?, description = ?, typeAccountId = ? WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setDate(2, user.getUserDOB());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setBoolean(5, user.isGender());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getAvatar());
            ps.setBoolean(8, user.isStatus());
            ps.setString(9, user.getDescription());
            ps.setInt(10, user.getTypeAccountId());
            ps.setInt(11, user.getUserID());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public void deleteUser(int userId) {
        String query = "DELETE FROM users WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public boolean addNewUser(User user) {
        String query = "INSERT INTO users (name, userDOB, email, phoneNumber, gender, address, avatar, status, description, typeAccountId, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setDate(2, user.getUserDOB());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setBoolean(5, user.isGender());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getAvatar());
            ps.setBoolean(8, user.isStatus());
            ps.setString(9, user.getDescription());
            ps.setInt(10, user.getTypeAccountId());
            ps.setString(11, EncryptUtils.encrypt(user.getPassword()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean blockUser(int userId) {
        String query = "UPDATE users SET isBan = 1 WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean unblockUser(int userId) {
        String query = "UPDATE users SET isBan = 0 WHERE userId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
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
