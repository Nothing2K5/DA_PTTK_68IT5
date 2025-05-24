/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class TramXe {

    private String tramXeID;
    private String tenTram;
    private String diaChi;
    private Integer tongChoDo;
    private Integer soXeKhaDung;
    private Integer soChoTrong;

    public TramXe() {

    }

    public TramXe(String tramXeID, String tenTram, String diaChi, Integer tongChoDo, Integer soXeKhaDung, Integer soChoTrong) {
        this.tramXeID = tramXeID;
        this.tenTram = tenTram;
        this.diaChi = diaChi;
        this.tongChoDo = tongChoDo;
        this.soXeKhaDung = soXeKhaDung;
        this.soChoTrong = soChoTrong;
    }

    public String getTramXeID() {
        return tramXeID;
    }

    public void setTramXeID(String tramXeID) {
        this.tramXeID = tramXeID;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getTongChoDo() {
        return tongChoDo;
    }

    public void setTongChoDo(Integer tongChoDo) {
        this.tongChoDo = tongChoDo;
    }

    public Integer getSoXeKhaDung() {
        return soXeKhaDung;
    }

    public void setSoXeKhaDung(Integer soXeKhaDung) {
        this.soXeKhaDung = soXeKhaDung;
    }

    public Integer getSoChoTrong() {
        return soChoTrong;
    }

    public void setSoChoTrong(Integer soChoTrong) {
        this.soChoTrong = soChoTrong;
    }

}
