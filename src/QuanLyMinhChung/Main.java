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

        // Tim va Xoa Minh Chung
        MinhChung m1 = new MinhChung("MinhChung1", "TPCHM", "2/05/2003");
        MinhChung m2 = new MinhChung("MinhChung2", "Hue", "13/05/2003");
        MinhChung m3 = new MinhChung("MinhChung3","Binh Dinh","1/1/2000");
        TieuChuan tc1 = new TieuChuan("Tieu Chuan 1","Noi Dung 1");
        TieuChi tieuChi1 = new TieuChi("Tieu chi 1","Noi Dung tieu chi 1",tc1);
        tieuChi1.addMinhChung(m1,m2,m3);
        tieuChi1.sapXepMinhChungNgayBanHanh();
        tieuChi1.displayTieuChi();
        System.out.print("=============================\n");
        tieuChi1.updateOrAddMinhChung();
        System.out.print("=============================\n");
        tieuChi1.displayTieuChi();
    }

}
