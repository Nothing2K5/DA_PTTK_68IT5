package com.pttk.dao;

import com.pttk.contex.*;
import com.pttk.entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class TaiKhoanDAO extends AbstractDAO<TaiKhoan> {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TaiKhoan login(String sdt, String matKhau) {
        String query = "SELECT * FROM TaiKhoan WHERE Sdt = ? AND MatKhau = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sdt);
            ps.setString(2, matKhau);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public TaiKhoan checkAccountExist(String sdt) {
        String query = "SELECT * FROM TaiKhoan WHERE Sdt = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sdt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void signUp(String hoTen, String email, String sdt, String matKhau) {
        String query = "INSERT INTO TaiKhoan (TKID, MatKhau, VaiTro, Sdt, SoDu) VALUES (?,?,'User',?,0)";
        String tkid = generatedID("TK", findLastItem(findAll()).getTKID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            ps.setString(2, matKhau);
            ps.setString(3, sdt);
            ps.executeUpdate();
            NguoiDungDAO nd = new NguoiDungDAO();
            nd.add(tkid, hoTen, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TaiKhoan> findAll() {
        String query = "SELECT *FROM TaiKhoan";
        List<TaiKhoan> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoan findOne(String tkid) {
        String query = "SELECT * FROM TaiKhoan WHERE TKID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String add(String sdt, String matKhau) {
        String query = "INSERT INTO TaiKhoan (TKID, MatKhau, VaiTro, Sdt, SoDu) VALUES (?,?,'User',?,0)";
        String tkid = generatedID("TK", findLastItem(findAll()).getTKID());
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
            ps.setString(2, matKhau);
            ps.setString(3, sdt);
            if (ps.executeUpdate() > 0) {
                return tkid;
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

    public boolean update(String tkid, String matKhau, String vaiTro, String sdt, int soDu) {
        String query = "UPDATE TaiKhoan SET MatKhau = ?, VaiTro = ?, Sdt = ?, SoDu = ? WHERE TKID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, matKhau);
            ps.setString(2, vaiTro);
            ps.setString(3, sdt);
            ps.setInt(4, soDu);
            ps.setString(5, tkid);
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

    public boolean delete(String tkid) {
        String query = "DELETE FROM TaiKhoan WHERE TKID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tkid);
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
