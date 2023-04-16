package QuanLyMinhChung.CungCap;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.PhongBan.PhongBan;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CungCap {
    private PhongBan phongBan;
    public MinhChung minhChung;
    private Date ngayCungCap;
    private Date ngayTaoMinhChungSystem;

    public CungCap(){};
    public void ghiNhanCungCap(PhongBan phongBan, MinhChung minhChung, String ngayCungCap, String ngayTaoMinhChungSystem) {
        this.phongBan = phongBan;
        this.minhChung = minhChung;
        try {
            this.ngayCungCap = CauHinh.f.parse(ngayCungCap);
            this.ngayTaoMinhChungSystem = CauHinh.f.parse(ngayTaoMinhChungSystem);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.phongBan.getCungCapMinhChung().add(this);
        this.minhChung.getCungCapMinhChung().add(this);
    }
    public void xuatThongTin() {
        System.out.println("Phòng ban: " + phongBan.getTenPhongBan());
        System.out.println("Mã minh chứng: " + minhChung.getMaMinhChung());
        System.out.println("Ngày cung cấp: " + CauHinh.f.format(this.ngayCungCap));
        System.out.println("Ngày tạo minh chứng trong hệ thống: " + CauHinh.f.format(this.ngayTaoMinhChungSystem));
    }


    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public MinhChung getMinhChung() {
        return minhChung;
    }

    public void setMinhChung(MinhChung minhChung) {
        this.minhChung = minhChung;
    }

    public Date getNgayCungCap() {
        return ngayCungCap;
    }

    public void setNgayCungCap(Date ngayCungCap) {
        this.ngayCungCap = ngayCungCap;
    }

    public Date getNgayTaoMinhChungSystem() {
        return ngayTaoMinhChungSystem;
    }

    public void setNgayTaoMinhChungSystem(Date ngayTaoMinhChungSystem) {
        this.ngayTaoMinhChungSystem = ngayTaoMinhChungSystem;
    }


}
