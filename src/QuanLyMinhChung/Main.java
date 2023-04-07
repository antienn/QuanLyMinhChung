package QuanLyMinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;

public class Main {
    public static void main(String[] args) {
        MinhChung m1 = new MinhChung("001", "Nha Dat", "TPCHM", "22/11/2001");
        MinhChung m2 = new MinhChung("002", "Tang ca", "Ha No", "20/01/2003");
        QuanLiMinhChung dsMinhChung = new QuanLiMinhChung();
        dsMinhChung.addMinhChung(m1,m2);
        dsMinhChung.displayMinhChung();

    }
}
