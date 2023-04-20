package QuanLyMinhChung.User;

import QuanLyMinhChung.QuyenHan.QuyenHanGiangVien;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.YeuCau;

public class GiangVien extends User {
    private QuyenHanGiangVien qhgv = new QuyenHanGiangVien();

    public GiangVien(String name, String pass) {
        super(name, pass);
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(" | Được biên soạn tiêu chí: %s\n", (qhgv.isDuocBienSoanTieuChi() ? "Có" : "Không"));
        System.out.print("| Danh sách tiêu chí được quản lí: ");
        if (qhgv.getDsTieuChiDuocChinhSua().isEmpty()) {
            System.out.print("Không có tiêu chí nào được quản lí.\n");
        } else {
            System.out.printf(" \n Số lượng tiêu chí: %d\n", qhgv.getDsTieuChiDuocChinhSua().size());
            System.out.printf("| %-20s | %-20s | %s\n", "Mã tiêu chí", "Tên tiêu chí", "Nội dung tiêu chí");
            qhgv.getDsTieuChiDuocChinhSua().forEach(tieuChi -> {
                System.out.printf("| %-20s | %-20s | %s\n", tieuChi.getMaYeuCau(), tieuChi.getTenYeuCau(), tieuChi.getNoiDung());
            });
            System.out.println();
        }
    }

    public QuyenHanGiangVien getQhgv() {
        return qhgv;
    }



}
