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
        this.maMinhChung = String.format("MC%05d", ++countMinhChung);
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
        return String.format("-Ma Minh Chung : %s\n-Ten Minh Chung : %s\n-Noi Ban Hanh : %s\n-Ngay Ban Hanh :%s\n"
                , this.maMinhChung, this.tenMinhChung, this.noiBanHanh, CauHinh.f.format(this.ngayBanHanh));
    }

    public void display() {
        System.out.printf("-Ma Minh Chung : %s\n", this.maMinhChung);
        System.out.printf("-Ten Minh Chung : %s\n", this.tenMinhChung);
        System.out.printf("-Noi Ban Hanh : %s\n", this.noiBanHanh);
        System.out.printf("-Ngay Ban Hanh : %s\n", CauHinh.f.format(this.ngayBanHanh));
    }

    public MinhChung nhapThongTinChung() {
        System.out.print("Nhập tên Minh Chứng mới: ");
        String tenMinhChung = CauHinh.sc.nextLine();
        System.out.print("Nhập nơi ban hành: ");
        String noiBanHanh = CauHinh.sc.nextLine();
        System.out.println("Nhap ngay ban hanh moi (dd/MM/yyyy):");
        Date ngayBanHanhMoi = null;
        try {
            ngayBanHanhMoi = CauHinh.f.parse(CauHinh.sc.nextLine());
            MinhChung newMinhChung = new MinhChung(tenMinhChung,noiBanHanh,CauHinh.f.format(ngayBanHanhMoi));
            return newMinhChung;
        } catch (ParseException e) {
            System.out.println("Ngay ban hanh khong hop le.");
            return null;
        }
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
