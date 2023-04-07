package QuanLyMinhChung.PhongBan;

import QuanLyMinhChung.CungCap.CungCap;
import QuanLyMinhChung.MinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhongBan {


    private PhongBan phongBan;
    private MinhChung minhChung;
    private Date ngayCap;
    private Date ngayTaoMinhChungTheThong;
    private List<CungCap> cungCapList;
    public PhongBan(PhongBan phongBan, MinhChung minhChung, Date ngayCap, Date ngayTaoMinhChungTheThong ){
        this.phongBan = phongBan;
        this.minhChung = minhChung;
        this.ngayCap = ngayCap;
        this.ngayTaoMinhChungTheThong = ngayTaoMinhChungTheThong;
        this.cungCapList =  new ArrayList<>();
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

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayTaoMinhChungTheThong() {
        return ngayTaoMinhChungTheThong;
    }

    public void setNgayTaoMinhChungTheThong(Date ngayTaoMinhChungTheThong) {
        this.ngayTaoMinhChungTheThong = ngayTaoMinhChungTheThong;
    }

    public List<CungCap> getCungCapList() {
        return cungCapList;
    }

    public void setCungCapList(List<CungCap> cungCapList) {
        this.cungCapList = cungCapList;
    }



}
