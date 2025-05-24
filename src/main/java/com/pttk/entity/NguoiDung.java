/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class NguoiDung {

    private String userID;
    private String tkid;
    private String hoTen;
    private String email;

    public NguoiDung() {

    }

    public NguoiDung(String userID, String tkid, String hoTen, String email) {
        this.userID = userID;
        this.tkid = tkid;
        this.hoTen = hoTen;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
