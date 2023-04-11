package QuanLyMinhChung.QuyenHan;

import QuanLyMinhChung.YeuCau.TieuChi;

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

    public boolean isDuocBienSoanTieuChi() {
        return duocBienSoanTieuChi;
    }

    public void setDuocBienSoanTieuChi(boolean duocBienSoanTieuChi) {
        this.duocBienSoanTieuChi = duocBienSoanTieuChi;
    }
}
