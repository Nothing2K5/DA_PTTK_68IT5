package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class NguoiDungDAO extends AbstractDAO<NguoiDung> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<NguoiDung> findAll() {
        String query = "SELECT *FROM NguoiDung";
        List<NguoiDung> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NguoiDung(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NguoiDung findOne(String userID) {
        String query = "SELECT * FROM NguoiDung WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new NguoiDung(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NguoiDung findOneByTKID(String tkid) {
        String query = "SELECT * FROM NguoiDung WHERE TKID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new NguoiDung(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(String tkid, String hoTen, String email) {
        String query = "INSERT INTO NguoiDung (UserID, TKID, HoTen, Email) VALUES (?, ?, ?, ?)";
        String userID = generatedID("U", findLastItem(findAll()).getUserID());
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, tkid);
            ps.setString(3, hoTen);
            ps.setString(4, email);
            if (ps.executeUpdate() > 0) {
                return userID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean update(String userID, String tkid, String hoTen, String email) {
        String query = "UPDATE NguoiDung SET TKID = ?, HoTen = ?, Email = ? WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            ps.setString(2, hoTen);
            ps.setString(3, email);
            ps.setString(4, userID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(String userID) {
        String query = "DELETE FROM NguoiDung WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
