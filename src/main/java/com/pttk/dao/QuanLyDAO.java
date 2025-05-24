/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.QuanLy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class QuanLyDAO extends AbstractDAO<QuanLy> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<QuanLy> findAll() {
        String query = "SELECT * FROM QuanLy";
        List<QuanLy> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QuanLy(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public QuanLy findOne(String qlid) {
        String query = "SELECT * FROM QuanLy WHERE QLID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, qlid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new QuanLy(
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

    public QuanLy findByTKID(String tkid) {
        String query = "SELECT * FROM QuanLy WHERE TKID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new QuanLy(
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

    public List<QuanLy> findByHoTen(String hoTen) {
        String query = "SELECT * FROM QuanLy WHERE HoTen LIKE ?";
        List<QuanLy> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + hoTen + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QuanLy(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public QuanLy findByEmail(String email) {
        String query = "SELECT * FROM QuanLy WHERE Email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new QuanLy(
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

    public boolean checkEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM QuanLy WHERE Email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
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

    public String add(String tkid, String hoTen, String email) {
        String query = "INSERT INTO QuanLy (QLID, TKID, HoTen, Email) VALUES (?, ?, ?, ?)";
        String qlid = generatedID("QL", findLastItem(findAll()).getQlid());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, qlid);
            ps.setString(2, tkid);
            ps.setString(3, hoTen);
            ps.setString(4, email);
            if (ps.executeUpdate() > 0) {
                return qlid;
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

    public boolean update(String qlid, String tkid, String hoTen, String email) {
        String query = "UPDATE QuanLy SET TKID = ?, HoTen = ?, Email = ? WHERE QLID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            ps.setString(2, hoTen);
            ps.setString(3, email);
            ps.setString(4, qlid);
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

    public boolean updateProfile(String qlid, String hoTen, String email) {
        String query = "UPDATE QuanLy SET HoTen = ?, Email = ? WHERE QLID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hoTen);
            ps.setString(2, email);
            ps.setString(3, qlid);
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

    public boolean updateEmail(String qlid, String email) {
        String query = "UPDATE QuanLy SET Email = ? WHERE QLID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, qlid);
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

    public boolean delete(String qlid) {
        String query = "DELETE FROM QuanLy WHERE QLID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, qlid);
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

    public int getTotalQuanLy() {
        String query = "SELECT COUNT(*) FROM QuanLy";
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
}
