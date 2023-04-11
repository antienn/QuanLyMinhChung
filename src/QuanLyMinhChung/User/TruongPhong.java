package QuanLyMinhChung.User;

import QuanLyMinhChung.QuyenHan.QuyenHanTruongPhong;

public class TruongPhong extends User {
    private QuyenHanTruongPhong qhtp = new QuyenHanTruongPhong();
    public TruongPhong(String name, String pass) {
        super(name, pass);
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("1/Được cấp quyền cho giảng viên: %s \n",(!qhtp.getDsQuyenHan()[0] ?"Không":"Được"));
        System.out.printf("2/Được thêm bộ kiểm định: %s \n",(!qhtp.getDsQuyenHan()[1] ?"Không":"Được"));
        System.out.printf("3/Được thêm tiêu chuẩn: %s \n",(!qhtp.getDsQuyenHan()[2] ?"Không":"Được"));
        System.out.printf("4/Được thêm tiêu chi: %s \n",(!qhtp.getDsQuyenHan()[3] ?"Không":"Được"));

    }

    public QuyenHanTruongPhong getQhtp() {
        return qhtp;
    }

    public void setQhtp(int num) {
        this.qhtp.setRole(num);
    }
}
