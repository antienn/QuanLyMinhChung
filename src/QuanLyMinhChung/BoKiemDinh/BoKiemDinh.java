package QuanLyMinhChung.BoKiemDinh;

import QuanLyMinhChung.YeuCau.TieuChuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoKiemDinh {
    private String tenBoKiemDinh;
    private List<TieuChuan> dsTieuChuan = new ArrayList<>();

    public BoKiemDinh(String tenBoKiemDinh) {
        this.tenBoKiemDinh = tenBoKiemDinh;
    }

    //Them Tieu Chuan
    public void addTieuChuan(TieuChuan ... tieuChuans){
        this.dsTieuChuan.addAll(Arrays.asList(tieuChuans));
    }
    //Xoa Tieu Chuan
    public void removeTieuChuan(TieuChuan ...tieuChuans){
        for (TieuChuan tc : tieuChuans) {
            dsTieuChuan.remove(tc);
        }
    }
    public void display(){
        System.out.println("Tên bộ kiểm định: " + this.tenBoKiemDinh);
        System.out.println("Danh sách tiêu chuẩn: ");
        for (TieuChuan tc : this.dsTieuChuan) {
            tc.display();
        }
    }

    public String getTenBoKiemDinh() {
        return tenBoKiemDinh;
    }

    public void setTenBoKiemDinh(String tenBoKiemDinh) {
        this.tenBoKiemDinh = tenBoKiemDinh;
    }

    public List<TieuChuan> getDsTieuChuan() {
        return dsTieuChuan;
    }

    public void setDsTieuChuan(List<TieuChuan> dsTieuChuan) {
        this.dsTieuChuan = dsTieuChuan;
    }

}
