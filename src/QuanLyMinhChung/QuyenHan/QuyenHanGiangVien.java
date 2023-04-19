package QuanLyMinhChung.QuyenHan;

import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.YeuCau;

import java.util.ArrayList;
import java.util.List;

public class QuyenHanGiangVien {
    private final List<TieuChi> dsTieuChiDuocChinhSua = new ArrayList<>();
    private boolean duocBienSoanTieuChi = false;
    public QuyenHanGiangVien(){
        this.duocBienSoanTieuChi = false;
    }

    public List<TieuChi> getDsTieuChiDuocChinhSua() {
        return dsTieuChiDuocChinhSua;
    }

    public void show(){
        this.dsTieuChiDuocChinhSua.forEach(x -> System.out.println(x.getTenYeuCau()));
    }
    public TieuChi findTieuChi(String name){
        for( TieuChi tc : dsTieuChiDuocChinhSua){
            if(tc.getTenYeuCau().equals(name)){
                return tc;
            }
        }
        return null;
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
