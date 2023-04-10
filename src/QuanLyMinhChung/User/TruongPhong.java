package QuanLyMinhChung.User;

public class TruongPhong extends User {
    private final boolean duocCapQuyenchoGiangVien;
    public TruongPhong(String name, String pass) {
        super(name, pass);
        this.duocCapQuyenchoGiangVien = false;
    }
    public TruongPhong(String name, String pass,boolean duocCapQuyenChoGiangVien) {
        super(name, pass);
        this.duocCapQuyenchoGiangVien = duocCapQuyenChoGiangVien;
    }
}
