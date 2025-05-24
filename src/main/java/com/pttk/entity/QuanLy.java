/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class QuanLy {

    private String qlid;
    private String tkid;
    private String hoTen;
    private String Email;

    public QuanLy() {

    }

    public QuanLy(String qlid, String tkid, String hoTen, String Email) {
        this.qlid = qlid;
        this.tkid = tkid;
        this.hoTen = hoTen;
        this.Email = Email;
    }

    public String getQlid() {
        return qlid;
    }

    public void setQlid(String qlid) {
        this.qlid = qlid;
    }

    public String getTkid() {
        return tkid;
    }

    public void setTkid(String tkid) {
        this.tkid = tkid;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
