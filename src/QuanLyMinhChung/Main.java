package QuanLyMinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.PhongBan.PhongBan;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //test chuc nang

        PhongBan phongBan = new PhongBan("PBO1","Quan Li so do","TPHCM");
        MinhChung minhChung1 = new MinhChung("C01","Quan Li so Do","TPHHCM","22/01/2001");
        MinhChung minhChung2 = new MinhChung("C02","Quan Li so Do","TPHHCM","22/01/2002");

        CungCap cungCap1 = new CungCap(phongBan, minhChung1, "22/01/2001", "19/1/2003");
        CungCap cungCap2 = new CungCap(phongBan, minhChung2, "23/01/2002", "20/1/2004");
        //ham Test Quan Li Minh Chung
        QuanLiMinhChung dsMinhChung = new QuanLiMinhChung();
        dsMinhChung.addMinhChung(minhChung1,minhChung2);
        dsMinhChung.displayMinhChung();
        // Hàm test cungCap quan hệ nhiều nhiều giữa Minh Chung với Phòng Ban
        cungCap2.xuatThongTin();
        cungCap1.xuatThongTin();


    }
}
