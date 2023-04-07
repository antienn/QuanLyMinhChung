package QuanLyMinhChung.CungCap;

import QuanLyMinhChung.CauHinh.CauHinh;

import java.text.ParseException;
import java.util.Date;

public class CungCap {
    private String maPhongBan;
    private String maMinhChung;

    public CungCap(String maPhongBan, String maMinhChung, Date ngayCungCapCuaTungBan, Date ngayTaoMinhChungSystem) {
        this.maPhongBan = maPhongBan;
        this.maMinhChung = maMinhChung;
        this.ngayCungCapCuaTungBan = ngayCungCapCuaTungBan;
        this.ngayTaoMinhChungSystem = ngayTaoMinhChungSystem;
    }
    public CungCap(String maPhongBan, String maMinhChung, String ngayCungCapCuaTungBan, String ngayTaoMinhChungSystem) {
        this.maPhongBan = maPhongBan;
        this.maMinhChung = maMinhChung;
        try{
            this.ngayCungCapCuaTungBan = CauHinh.f.parse(ngayCungCapCuaTungBan);
            this.ngayTaoMinhChungSystem = CauHinh.f.parse(ngayTaoMinhChungSystem);
        }catch (ParseException ex){
            ex.printStackTrace();
        }

    }

    private Date ngayCungCapCuaTungBan;
    private Date ngayTaoMinhChungSystem;
    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getMaMinhChung() {
        return maMinhChung;
    }

    public void setMaMinhChung(String maMinhChung) {
        this.maMinhChung = maMinhChung;
    }

    public Date getNgayCungCapCuaTungBan() {
        return ngayCungCapCuaTungBan;
    }

    public void setNgayCungCapCuaTungBan(Date ngayCungCapCuaTungBan) {
        this.ngayCungCapCuaTungBan = ngayCungCapCuaTungBan;
    }

    public Date getNgayTaoMinhChungSystem() {
        return ngayTaoMinhChungSystem;
    }

    public void setNgayTaoMinhChungSystem(Date ngayTaoMinhChungSystem) {
        this.ngayTaoMinhChungSystem = ngayTaoMinhChungSystem;
    }


}
