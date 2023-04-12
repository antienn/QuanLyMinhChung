package QuanLyMinhChung.User;

import QuanLyMinhChung.QuyenHan.QuyenHanGiangVien;
import QuanLyMinhChung.YeuCau.YeuCau;

public class GiangVien extends User {
    private QuyenHanGiangVien qhgv = new QuyenHanGiangVien();

    public GiangVien(String name, String pass) {
        super(name, pass);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Danh sách tiêu chí được quản lí");
        if (getQhgv().getDsTieuChiDuocChinhSua().size() == 0) {
            System.out.println("none");
        } else {
            qhgv.getDsTieuChiDuocChinhSua().forEach(YeuCau::display);
        }
        System.out.printf("Được biên soạn tiêu chí: %s \n", (!qhgv.isDuocBienSoanTieuChi() ? "KHÔNG" : "ĐƯỢC"));

    }

    public QuyenHanGiangVien getQhgv() {
        return qhgv;
    }

    public void setQhgv(QuyenHanGiangVien qhgv) {
        this.qhgv = qhgv;
    }

}
