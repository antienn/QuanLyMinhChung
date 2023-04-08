package QuanLyMinhChung.MinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class MinhChung {
    private static  int countMinhChung;
    private String maMinhChung;
    private  String tenMinhChung;
    private String noiBanHanh;
    private Date ngayBanHanh;
    private List<CungCap> cungCapMinhChung;

    public MinhChung(String maMinhChung, String tenMinhChung, String noiBanHanh, String ngayBanHanh) {
        this.maMinhChung = maMinhChung;
        this.tenMinhChung = tenMinhChung;
        this.noiBanHanh = noiBanHanh;
        try {
            this.ngayBanHanh = CauHinh.f.parse(ngayBanHanh);
        }catch(ParseException e){
            e.printStackTrace();
        }
        this.cungCapMinhChung =new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("-Ma Minh Chung : %s\n-Ten Minh Chung : %s\n-Noi Ban Hanh : %s\n-Ngay Ban Hanh :%s\n"
                ,this.maMinhChung,this.tenMinhChung,this.noiBanHanh, CauHinh.f.format(this.ngayBanHanh));
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
