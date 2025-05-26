/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.dao;

import com.pttk.contex.DBContext;
import com.pttk.entity.DatXe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class DatXeDAO extends AbstractDAO<DatXe> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<DatXe> findAll() {
        String query = "SELECT * FROM DatXe";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DatXe findOne(String datXeID) {
        String query = "SELECT * FROM DatXe WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DatXe> findByUser(String userID) {
        String query = "SELECT * FROM DatXe WHERE UserID = ? ORDER BY Ngay DESC";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DatXe> findByXe(String xeID) {
        String query = "SELECT * FROM DatXe WHERE XeID = ? ORDER BY Ngay DESC";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, xeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DatXe> findByTrangThai(String trangThai) {
        String query = "SELECT * FROM DatXe WHERE TrangThai = ? ORDER BY Ngay DESC";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, trangThai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DatXe> findByNgay(Date ngay) {
        String query = "SELECT * FROM DatXe WHERE Ngay = ?";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(ngay.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DatXe> findDangChoThue(String userID) {
        String query = "SELECT * FROM DatXe WHERE UserID = ? AND ThoiGianChoThue = '00:00:00' AND TrangThai = N'Đã đặt'";
        List<DatXe> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DatXe(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(String userID, String xeID, Date ngay, String thoiGianBatDau, String thoiGianKetThuc, String thoiGianChoThue, String trangThai, int chiPhi) {
        String query = "INSERT INTO DatXe (DatXeID, UserID, XeID, Ngay, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianChoThue, TrangThai, ChiPhi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String datXeID = generatedID("D", findLastItem(findAll()).getDatXeID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
            ps.setString(2, userID);
            ps.setString(3, xeID);
            ps.setDate(4, ngay);
            ps.setString(5, thoiGianBatDau);
            ps.setString(6, thoiGianKetThuc);
            ps.setString(7, thoiGianChoThue);
            ps.setString(8, trangThai);
            ps.setInt(9, chiPhi);
            if (ps.executeUpdate() > 0) {
                return datXeID;
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

    public boolean update(String datXeID, String userID, String xeID, Date ngay, String thoiGianBatDau, String thoiGianKetThuc, String thoiGianChoThue, String trangThai, int chiPhi) {
        String query = "UPDATE DatXe SET UserID = ?, XeID = ?, Ngay = ?, ThoiGianBatDau = ?, ThoiGianKetThuc = ?, ThoiGianChoThue = ?, TrangThai = ?, ChiPhi = ? WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, xeID);
            ps.setDate(3, ngay);
            ps.setString(4, thoiGianBatDau);
            ps.setString(5, thoiGianKetThuc);
            ps.setString(6, thoiGianChoThue);
            ps.setString(7, trangThai);
            ps.setInt(8, chiPhi);
            ps.setString(9, datXeID);
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

    public boolean updateTrangThai(String datXeID, String trangThai) {
        String query = "UPDATE DatXe SET TrangThai = ? WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, trangThai);
            ps.setString(2, datXeID);
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

    public boolean updateThoiGianKetThuc(String datXeID, String thoiGianKetThuc, String thoiGianChoThue, String chiPhi) {
        String query = "UPDATE DatXe SET ThoiGianKetThuc = ?, ThoiGianChoThue = ?, ChiPhi = ? WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, thoiGianKetThuc);
            ps.setString(2, thoiGianChoThue);
            ps.setString(3, chiPhi);
            ps.setString(4, datXeID);
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

    public boolean hoanThanhDatXe(String datXeID, String thoiGianKetThuc, String thoiGianChoThue, String chiPhi) {
        String query = "UPDATE DatXe SET ThoiGianKetThuc = ?, ThoiGianChoThue = ?, ChiPhi = ?, TrangThai = 'Hoàn thành' WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, thoiGianKetThuc);
            ps.setString(2, thoiGianChoThue);
            ps.setString(3, chiPhi);
            ps.setString(4, datXeID);
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

    public boolean delete(String datXeID) {
        String query = "DELETE FROM DatXe WHERE DatXeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, datXeID);
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
