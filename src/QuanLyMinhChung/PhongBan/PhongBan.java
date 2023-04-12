package QuanLyMinhChung.PhongBan;

import QuanLyMinhChung.CungCap.CungCap;

import java.util.ArrayList;
import java.util.List;

public class PhongBan {

    private  static  int countMaPhongBan;
    private String maPhongBan;
    private String tenPhongBan;
    private String diaDiemPhongBan;
    private List<CungCap> cungCapList;
    {
        maPhongBan = String.format("PB%05d",++countMaPhongBan);
    }
    public PhongBan( String tenPhongBan, String diaDiemPhongBan) {
        this.tenPhongBan = tenPhongBan;
        this.diaDiemPhongBan = diaDiemPhongBan;
        this.cungCapList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
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
