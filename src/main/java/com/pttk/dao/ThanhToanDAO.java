package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.ThanhToan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class ThanhToanDAO extends AbstractDAO<ThanhToan> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ThanhToan> findAll() {
        String query = "SELECT * FROM ThanhToan";
        List<ThanhToan> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThanhToan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThanhToan findOne(String thanhToanID) {
        String query = "SELECT * FROM ThanhToan WHERE ThanhToanID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, thanhToanID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new ThanhToan(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThanhToan findByDatXe(String datXeID) {
        String query = "SELECT * FROM ThanhToan WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new ThanhToan(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThanhToan> findByUserID(String userID) {
        String query = "SELECT tt.* FROM ThanhToan tt INNER JOIN DatXe dx ON tt.DatXeID = dx.DatXeID WHERE dx.UserID = ? ORDER BY tt.ThanhToanID DESC";
        List<ThanhToan> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThanhToan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThanhToan> findBySoTienRange(Integer minAmount, Integer maxAmount) {
        String query = "SELECT * FROM ThanhToan WHERE SoTienThanhToan BETWEEN ? AND ? ORDER BY SoTienThanhToan DESC";
        List<ThanhToan> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, minAmount);
            ps.setInt(2, maxAmount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThanhToan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkThanhToanExists(String datXeID) {
        String query = "SELECT COUNT(*) FROM ThanhToan WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
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
        return false;
    }

    public String add(String datXeID, Integer soTienThanhToan) {
        String query = "INSERT INTO ThanhToan (ThanhToanID, DatXeID, SoTienThanhToan) VALUES (?, ?, ?)";
        String thanhToanID = generatedID("TT", findLastItem(findAll()).getThanhToanID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, thanhToanID);
            ps.setString(2, datXeID);
            ps.setInt(3, soTienThanhToan);
            if (ps.executeUpdate() > 0) {
                return thanhToanID;
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

    public boolean update(String thanhToanID, String datXeID, Integer soTienThanhToan) {
        String query = "UPDATE ThanhToan SET DatXeID = ?, SoTienThanhToan = ? WHERE ThanhToanID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
            ps.setInt(2, soTienThanhToan);
            ps.setString(3, thanhToanID);
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

    public boolean updateSoTien(String thanhToanID, Integer soTienThanhToan) {
        String query = "UPDATE ThanhToan SET SoTienThanhToan = ? WHERE ThanhToanID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, soTienThanhToan);
            ps.setString(2, thanhToanID);
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

    public boolean delete(String thanhToanID) {
        String query = "DELETE FROM ThanhToan WHERE ThanhToanID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, thanhToanID);
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

    public Integer getTongDoanhThu() {
        String query = "SELECT SUM(SoTienThanhToan) FROM ThanhToan";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }

    public Integer getTongDoanhThuByUser(String userID) {
        String query = "SELECT SUM(tt.SoTienThanhToan) FROM ThanhToan tt INNER JOIN DatXe dx ON tt.DatXeID = dx.DatXeID WHERE dx.UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }

    public int getTotalThanhToan() {
        String query = "SELECT COUNT(*) FROM ThanhToan";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }

    public Double getAverageThanhToan() {
        String query = "SELECT AVG(CAST(SoTienThanhToan AS FLOAT)) FROM ThanhToan";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
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
        return 0.0;
    }
}
