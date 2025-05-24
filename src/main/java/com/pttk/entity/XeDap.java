/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class XeDap {

    private String xeID;
    private String tramXeID;
    private String loaiXe;
    private String trangThaiXe;

    public XeDap() {
    }
    
    public XeDap(String xeID, String tramXeID, String loaiXe, String trangThaiXe) {
        this.xeID = xeID;
        this.tramXeID = tramXeID;
        this.loaiXe = loaiXe;
        this.trangThaiXe = trangThaiXe;
    }
    
    public String getXeID() {
        return xeID;
    }

    public void setXeID(String xeID) {
        this.xeID = xeID;
    }

    public String getTramXeID() {
        return tramXeID;
    }

    public void setTramXeID(String tramXeID) {
        this.tramXeID = tramXeID;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getTrangThaiXe() {
        return trangThaiXe;
    }

    public void setTrangThaiXe(String trangThaiXe) {
        this.trangThaiXe = trangThaiXe;
    }

}
