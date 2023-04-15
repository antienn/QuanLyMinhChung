package QuanLyMinhChung;

import QuanLyMinhChung.BoKiemDinh.BoKiemDinh;
import QuanLyMinhChung.BoKiemDinh.QuanLyBoKiemDinh;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.TieuChuan;

import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TieuChuan tc1 = new TieuChuan("Ielts","Cai thien tieng anh");
        TieuChi tchi1 = new TieuChi("TieuChi1","Noi Dung Tieu chi",tc1);
        MinhChung minhChung = new MinhChung("MinhCHUNG1","HCM","22/1/2003");
        tchi1.addMinhChung(minhChung);
        tchi1.displayTieuChi();
        tchi1.updateOrAddMinhChung();
        tchi1.displayTieuChi();
    }
}
