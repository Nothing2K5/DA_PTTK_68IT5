package com.pttk.entity;

/**
 *
 * @author HOANGHA
 */
public class TaiKhoan {

    private String tkid;
    private String matKhau;
    private String vaiTro;
    private String sdt;
    private int soDu;

    public TaiKhoan() {

    }

    public TaiKhoan(String tkid, String matKhau, String vaiTro, String sdt, int soDu) {
        this.tkid = tkid;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.sdt = sdt;
        this.soDu = soDu;
    }

    public String getTKID() {
        return tkid;
    }

    public void setTKID(String tkid) {
        this.tkid = tkid;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoDu() {
        return soDu;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

}
