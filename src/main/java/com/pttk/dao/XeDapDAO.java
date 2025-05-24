package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.XeDap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class XeDapDAO extends AbstractDAO<XeDap> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<XeDap> findAll() {
        String query = "SELECT * FROM XeDap";
        List<XeDap> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new XeDap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public XeDap findOne(String xeID) {
        String query = "SELECT * FROM XeDap WHERE XeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, xeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new XeDap(
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

    public List<XeDap> findByTramXe(String tramXeID) {
        String query = "SELECT * FROM XeDap WHERE TramXeID = ?";
        List<XeDap> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new XeDap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<XeDap> findByTrangThai(String trangThaiXe) {
        String query = "SELECT * FROM XeDap WHERE TrangThaiXe = ?";
        List<XeDap> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, trangThaiXe);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new XeDap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(String tramXeID, String loaiXe, String trangThaiXe) {
        String query = "INSERT INTO XeDap (XeID, TramXeID, LoaiXe, TrangThaiXe) VALUES (?, ?, ?, ?)";
        String xeID = generatedID("X", findLastItem(findAll()).getXeID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, xeID);
            ps.setString(2, tramXeID);
            ps.setString(3, loaiXe);
            ps.setString(4, trangThaiXe);
            if (ps.executeUpdate() > 0) {
                return xeID;
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

    public boolean update(String xeID, String tramXeID, String loaiXe, String trangThaiXe) {
        String query = "UPDATE XeDap SET TramXeID = ?, LoaiXe = ?, TrangThaiXe = ? WHERE XeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
            ps.setString(2, loaiXe);
            ps.setString(3, trangThaiXe);
            ps.setString(4, xeID);
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

    public boolean updateTrangThai(String xeID, String trangThaiXe) {
        String query = "UPDATE XeDap SET TrangThaiXe = ? WHERE XeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, trangThaiXe);
            ps.setString(2, xeID);
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

    public boolean delete(String xeID) {
        String query = "DELETE FROM XeDap WHERE XeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, xeID);
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
