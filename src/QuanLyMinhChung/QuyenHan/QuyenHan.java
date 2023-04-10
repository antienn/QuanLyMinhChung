package QuanLyMinhChung.QuyenHan;

import QuanLyMinhChung.CauHinh.BoPhan;
import QuanLyMinhChung.CauHinh.ThaoTac;

public class QuyenHan {
    private BoPhan ndChinhSua;
    private ThaoTac phuongThuc;

    public QuyenHan(BoPhan ndChinhSua, ThaoTac phuongThuc) {
        this.ndChinhSua = ndChinhSua;
        this.phuongThuc = phuongThuc;
    }
    public void show(){
        System.out.printf("%s %s \n",this.phuongThuc,this.ndChinhSua);
    }
}
