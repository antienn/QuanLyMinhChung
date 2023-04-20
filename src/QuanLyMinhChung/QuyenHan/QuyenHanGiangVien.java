package QuanLyMinhChung.QuyenHan;

import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.YeuCau;

import java.util.ArrayList;
import java.util.List;

public class QuyenHanGiangVien {
    private final List<TieuChi> dsTieuChiDuocChinhSua = new ArrayList<>();
    private boolean duocBienSoanTieuChi;
    public QuyenHanGiangVien(){
        this.duocBienSoanTieuChi = false;
    }

    public List<TieuChi> getDsTieuChiDuocChinhSua() {
        return dsTieuChiDuocChinhSua;
    }

    public TieuChi findTieuChi(String name){
        for( TieuChi tc : dsTieuChiDuocChinhSua){
            if(tc.getTenYeuCau().equals(name)){
                return tc;
            }
        }
        return null;
    }
    public void show() {
        if(this.dsTieuChiDuocChinhSua.isEmpty()){
            System.out.println("Danh Sách quản lý hiện tại chưa có :");
        }
        else {
            System.out.printf("%-20s | %-20s | %s\n", "Mã tiêu chí", "Tên tiêu chí", "Nội dung tiêu chí");
            for (TieuChi tc : this.getDsTieuChiDuocChinhSua()) {
                System.out.printf("%-20s | %-20s | %s\n", tc.getMaYeuCau(), tc.getTenYeuCau(), tc.getNoiDung());
            }
            System.out.println();
        }
    }

    public void addTieuChi(TieuChi tc){
        this.dsTieuChiDuocChinhSua.add(tc);
    }

    public boolean isDuocBienSoanTieuChi() {
        return duocBienSoanTieuChi;
    }

    public void setDuocBienSoanTieuChi() {
        this.duocBienSoanTieuChi = !duocBienSoanTieuChi;
    }
}
