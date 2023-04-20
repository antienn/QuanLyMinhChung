package QuanLyMinhChung;

import QuanLyMinhChung.BoKiemDinh.BoKiemDinh;
import QuanLyMinhChung.BoKiemDinh.QuanLyBoKiemDinh;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.PhongBan.PhongBan;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.TieuChuan;

import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
       PhongBan phongBan1 = new PhongBan("PhongBan1","Hue");
       PhongBan phongBan2 = new PhongBan("PhongBan2","Hcm");
       MinhChung minhChung1 = new MinhChung("MinhChung1","HCM","10/2/2000");
       MinhChung minhChung2 =  new MinhChung("MinhChung2","Hue","15/1/2000");
       CungCap cc = new CungCap();
       CungCap c2 = new CungCap();
       QuanLiMinhChung quanLiMinhChung = new QuanLiMinhChung();
       cc.ghiNhanCungCap(phongBan1,minhChung1,"10/11/2000","20/10/2000");
       c2.ghiNhanCungCap(phongBan2,minhChung2,"20/11/2000","20/10/2000");
       quanLiMinhChung.searchMinhChungByPhongBan("PhongBan1");
       quanLiMinhChung.displayMinhChung();



    }
}
