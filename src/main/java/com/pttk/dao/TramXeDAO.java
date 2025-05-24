/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.TramXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class TramXeDAO extends AbstractDAO<TramXe> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<TramXe> findAll() {
        String query = "SELECT * FROM TramXe";
        List<TramXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TramXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TramXe findOne(String tramXeID) {
        String query = "SELECT * FROM TramXe WHERE TramXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new TramXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TramXe> findByDiaChi(String diaChi) {
        String query = "SELECT * FROM TramXe WHERE DiaChi LIKE ?";
        List<TramXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + diaChi + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TramXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TramXe> findTramCoXe() {
        String query = "SELECT * FROM TramXe WHERE SoXeKhaDung > 0";
        List<TramXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TramXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TramXe> findTramCoChoTrong() {
        String query = "SELECT * FROM TramXe WHERE SoChoTrong > 0";
        List<TramXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TramXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(String tenTram, String diaChi, Integer tongChoDo) {
        String query = "INSERT INTO TramXe (TramXeID, TenTram, DiaChi, TongChoDo, SoXeKhaDung, SoChoTrong) VALUES (?, ?, ?, ?, ?, ?)";
        String tramXeID = generatedID("T", findLastItem(findAll()).getTramXeID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
            ps.setString(2, tenTram);
            ps.setString(3, diaChi);
            ps.setInt(4, tongChoDo);
            ps.setInt(5, 0); // Ban đầu chưa có xe nào
            ps.setInt(6, tongChoDo); // Tất cả chỗ đều trống
            if (ps.executeUpdate() > 0) {
                return tramXeID;
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

    public boolean update(String tramXeID, String tenTram, String diaChi, Integer tongChoDo, Integer soXeKhaDung, Integer soChoTrong) {
        String query = "UPDATE TramXe SET TenTram = ?, DiaChi = ?, TongChoDo = ?, SoXeKhaDung = ?, SoChoTrong = ? WHERE TramXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tenTram);
            ps.setString(2, diaChi);
            ps.setInt(3, tongChoDo);
            ps.setInt(4, soXeKhaDung);
            ps.setInt(5, soChoTrong);
            ps.setString(6, tramXeID);
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

    public boolean updateSoLuongXe(String tramXeID, Integer soXeKhaDung, Integer soChoTrong) {
        String query = "UPDATE TramXe SET SoXeKhaDung = ?, SoChoTrong = ? WHERE TramXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, soXeKhaDung);
            ps.setInt(2, soChoTrong);
            ps.setString(3, tramXeID);
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

    public boolean themXeVaoTram(String tramXeID) {
        String query = "UPDATE TramXe SET SoXeKhaDung = SoXeKhaDung + 1, SoChoTrong = SoChoTrong - 1 WHERE TramXeID = ? AND SoChoTrong > 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
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

    public boolean layXeKhoiTram(String tramXeID) {
        String query = "UPDATE TramXe SET SoXeKhaDung = SoXeKhaDung - 1, SoChoTrong = SoChoTrong + 1 WHERE TramXeID = ? AND SoXeKhaDung > 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
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

    public boolean delete(String tramXeID) {
        String query = "DELETE FROM TramXe WHERE TramXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tramXeID);
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
