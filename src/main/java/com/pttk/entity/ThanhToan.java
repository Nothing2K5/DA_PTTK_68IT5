/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class ThanhToan {

    private String thanhToanID;
    private String datXeID;
    private Integer soTienThanhToan;

    public ThanhToan() {

    }

    public ThanhToan(String thanhToanID, String datXeID, Integer soTienThanhToan) {
        this.thanhToanID = thanhToanID;
        this.datXeID = datXeID;
        this.soTienThanhToan = soTienThanhToan;
    }

    public String getThanhToanID() {
        return thanhToanID;
    }

    public void setThanhToanID(String thanhToanID) {
        this.thanhToanID = thanhToanID;
    }

    public String getDatXeID() {
        return datXeID;
    }

    public void setDatXeID(String datXeID) {
        this.datXeID = datXeID;
    }

    public Integer getSoTienThanhToan() {
        return soTienThanhToan;
    }

    public void setSoTienThanhToan(Integer soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }

}
