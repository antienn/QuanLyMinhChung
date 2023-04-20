package QuanLyMinhChung.MinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MinhChung {
    private static int countMinhChung;
    private String maMinhChung;
    private String tenMinhChung;
    private String noiBanHanh;
    private Date ngayBanHanh;
    private List<CungCap> cungCapMinhChung;

    {
        maMinhChung = String.format("MC%05d", ++countMinhChung);
    }

    public MinhChung() {
    }

    public MinhChung(String tenMinhChung, String noiBanHanh, Date ngayBanHanh) {
        this.tenMinhChung = tenMinhChung;
        this.noiBanHanh = noiBanHanh;
        this.ngayBanHanh = ngayBanHanh;
    }


    {
        maMinhChung = String.format("MC%05d", ++countMinhChung);
    }

    public MinhChung(String tenMinhChung, String noiBanHanh, String ngayBanHanh) {
        this.tenMinhChung = tenMinhChung;
        this.noiBanHanh = noiBanHanh;
        try {
            this.ngayBanHanh = CauHinh.f.parse(ngayBanHanh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cungCapMinhChung = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-30s %-40s %-60s\n", this.maMinhChung, this.tenMinhChung, this.noiBanHanh, CauHinh.f.format(this.ngayBanHanh)));
        return sb.toString();
    }

    public void display() {
        System.out.format("%-20s %-20s %-20s %-20s\n", "Mã Minh Chung", "Tên Minh Chung", "Nơi Ban Hành", "Ngày Ban Hành");
        System.out.format("%-20s %-20s %-20s %-20s\n", this.maMinhChung, this.tenMinhChung, this.noiBanHanh, CauHinh.f.format(this.ngayBanHanh));
    }





    public String getMaMinhChung() {
        return maMinhChung;
    }

    public void setMaMinhChung(String maMinhChung) {
        this.maMinhChung = maMinhChung;
    }

    public String getTenMinhChung() {
        return tenMinhChung;
    }

    public void setTenMinhChung(String tenMinhChung) {
        this.tenMinhChung = tenMinhChung;
    }

    public String getNoiBanHanh() {
        return noiBanHanh;
    }

    public void setNoiBanHanh(String noiBanHanh) {
        this.noiBanHanh = noiBanHanh;
    }

    public Date getNgayBanHanh() {
        return ngayBanHanh;
    }

    public void setNgayBanHanh(Date ngayBanHanh) {
        this.ngayBanHanh = ngayBanHanh;
    }

    public List<CungCap> getCungCapMinhChung() {
        return cungCapMinhChung;
    }

    public void setCungCapMinhChung(List<CungCap> cungCapMinhChung) {
        this.cungCapMinhChung = cungCapMinhChung;
    }


}
