/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

import java.sql.Date;

/**
 *
 * @author HOANGHA
 */
public class DatXe {

    private String datXeID;
    private String userID;
    private String xeID;
    private Date ngay;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String thoiGianChoThue;
    private String trangThai;
    private String chiPhi;

    public DatXe() {
    }

    public DatXe(String datXeID, String userID, String xeID, Date ngay, String thoiGianBatDau, String thoiGianKetThuc, String thoiGianChoThue, String trangThai, String chiPhi) {
        this.datXeID = datXeID;
        this.userID = userID;
        this.xeID = xeID;
        this.ngay = ngay;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.thoiGianChoThue = thoiGianChoThue;
        this.trangThai = trangThai;
        this.chiPhi = chiPhi;
    }

    public String getDatXeID() {
        return datXeID;
    }

    public void setDatXeID(String datXeID) {
        this.datXeID = datXeID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getXeID() {
        return xeID;
    }

    public void setXeID(String xeID) {
        this.xeID = xeID;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getThoiGianChoThue() {
        return thoiGianChoThue;
    }

    public void setThoiGianChoThue(String thoiGianChoThue) {
        this.thoiGianChoThue = thoiGianChoThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(String chiPhi) {
        this.chiPhi = chiPhi;
    }

}
