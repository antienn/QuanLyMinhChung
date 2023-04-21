package QuanLyMinhChung.BoKiemDinh;

import QuanLyMinhChung.YeuCau.TieuChuan;
import QuanLyMinhChung.YeuCau.YeuCau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoKiemDinh {
    private String tenBoKiemDinh;
    private List<TieuChuan> dsTieuChuan = new ArrayList<>();

    public BoKiemDinh(String tenBoKiemDinh,List<TieuChuan> tmp) {
        if(tmp.size()<5){
            throw new IllegalArgumentException("1 Bộ kiểm định ít nhất 5 tiêu chuẩn.");
        }
        this.tenBoKiemDinh = tenBoKiemDinh;
        this.dsTieuChuan.addAll(tmp);
    }


    public void addTieuChuan(TieuChuan ... tieuChuans){
        if(this.dsTieuChuan.size() + tieuChuans.length > 20){
            throw new IllegalArgumentException("1 Bộ kiểm định nhiều nhất 20 tiêu chuẩn.");
        }
        this.dsTieuChuan.addAll(Arrays.asList(tieuChuans));
    }
    //Xoa Tieu Chuan
    public void removeTieuChuan(TieuChuan ...tieuChuans){
        for (TieuChuan tc : tieuChuans) {
            dsTieuChuan.remove(tc);
        }
    }
    public void display() {
        System.out.println("Tên bộ kiểm định: " + this.tenBoKiemDinh);
        System.out.print("\nDanh sách tiêu chuẩn: ");
        if (this.dsTieuChuan.size() == 0) {
            System.out.println("Không có");
        } else {
            String format = "| %-12s  | %-45s  | %-100s |%n";
            System.out.format("+--------------+---------------------------------------------+"
                    + "----------------------------------------------------------------------------------------------------+%n");
            System.out.format("| Mã Tiêu Chuẩn | Tên Tiêu Chuẩn | Nội dung Tiêu Chuẩn |%n");
            System.out.format("+--------------+---------------------------------------------+"
                    + "----------------------------------------------------------------------------------------------------+%n");
            for(TieuChuan tc : this.dsTieuChuan){
                System.out.format(format, tc.getMaYeuCau(), tc.getTenYeuCau(), tc.getNoiDung());
            }
            System.out.format("+--------------+---------------------------------------------+"
                    + "----------------------------------------------------------------------------------------------------+%n");
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
