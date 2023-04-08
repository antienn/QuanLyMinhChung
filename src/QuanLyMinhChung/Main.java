package QuanLyMinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.PhongBan.PhongBan;
import QuanLyMinhChung.YeuCau.QuanLyYeuCau;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.TieuChuan;
import QuanLyMinhChung.YeuCau.YeuCau;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //test chuc nang

//        PhongBan phongBan = new PhongBan("PBO1","Quan Li so do","TPHCM");
        MinhChung minhChung1 = new MinhChung("C01","Quan Li so Do","TPHHCM","22/01/2001");
//        MinhChung minhChung2 = new MinhChung("C02","Quan Li so Do","TPHHCM","22/01/2002");
//
//        CungCap cungCap1 = new CungCap(phongBan, minhChung1, "22/01/2001", "19/1/2003");
//        CungCap cungCap2 = new CungCap(phongBan, minhChung2, "23/01/2002", "20/1/2004");
//        //ham Test Quan Li Minh Chung
//        QuanLiMinhChung dsMinhChung = new QuanLiMinhChung();
//        dsMinhChung.addMinhChung(minhChung1,minhChung2);
//        dsMinhChung.displayMinhChung();
//        // Hàm test cungCap quan hệ nhiều nhiều giữa Minh Chung với Phòng Ban
//        cungCap2.xuatThongTin();
//        cungCap1.xuatThongTin();


        // ham test Minh Chung vs Tieu Chi
        QuanLyYeuCau yeuCau = new QuanLyYeuCau();
        YeuCau yc1 = new YeuCau("YC001", "Yêu cầu 1", "Nội Dung Yêu cầu 1");
        YeuCau yc2 = new YeuCau("YC002", "Yêu cầu 2", "Nội Dung Yêu cầu 2");

        TieuChuan tc1 = new TieuChuan("TC01", "Tieu Chuan 1", "Noi Dung Tieu chuan 1");
        TieuChi tieuChi1 = new TieuChi("TC001", "Tiêu chí số 1", "Nội dung tiêu chí số 1", "TC01");
        TieuChi tieuChi2 = new TieuChi("TC002", "Tiêu chí số 2", "Nội dung tiêu chí số 2", "TC01");

        TieuChuan tc2 = new TieuChuan("TC02", "Tieu Chuan 1", "Noi Dung Tieu chuan 1");
        TieuChi tieuChi3 = new TieuChi("TC003", "Tiêu chí số 3", "Nội dung tiêu chí số 1", "TC02");
        TieuChi tieuCh4 = new TieuChi("TC004", "Tiêu chí số 4", "Nội dung tiêu chí số 2", "TC02");

        tieuCh4.addMinhChung(minhChung1);
        tc1.addTieuChi(tieuChi1, tieuChi2);
        tc2.addTieuChi(tieuChi3,tieuCh4);

        yeuCau.addListTieuChuan(tc1,tc2);
        yeuCau.displayTieuChuan();
        yeuCau.removeTieuChuan("TC01");
        System.out.println(" ==========Xoa tieu chuan ==============");
        yeuCau.displayTieuChuan();
        // Xoa tieu Chuan



    }
}
