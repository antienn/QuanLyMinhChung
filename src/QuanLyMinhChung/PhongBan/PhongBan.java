package QuanLyMinhChung.PhongBan;

import QuanLyMinhChung.CungCap.CungCap;

import java.util.ArrayList;
import java.util.List;

public class PhongBan {


    private String maPhongBan;
    private String tenPhongBan;
    private String diaDiemPhongBan;
    private List<CungCap> cungCapList;
    public PhongBan(String maPhongBan, String tenPhongBan, String diaDiemPhongBan) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.diaDiemPhongBan = diaDiemPhongBan;
        this.cungCapList = new ArrayList<>();
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getDiaDiemPhongBan() {
        return diaDiemPhongBan;
    }

    public void setDiaDiemPhongBan(String diaDiemPhongBan) {
        this.diaDiemPhongBan = diaDiemPhongBan;
    }

    public List<CungCap> getCungCapList() {
        return cungCapList;
    }

    public void setCungCapList(List<CungCap> cungCapList) {
        this.cungCapList = cungCapList;
    }


}
