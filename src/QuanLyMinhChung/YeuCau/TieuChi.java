package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.MinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Arrays;

public class TieuChi extends YeuCau {
    private TieuChuan thuocTieuChuan;
    private ArrayList<MinhChung> dsMinhChung = new ArrayList<>();;

    public TieuChi(String maYeuCau, String tenYeuCau, String noiDung, TieuChuan tieuChuan) {
        super(maYeuCau, tenYeuCau, noiDung);
        this.thuocTieuChuan = tieuChuan;
    }

    // ham them Minh Chung
    public void addMinhChung(MinhChung... n) {
        this.dsMinhChung.addAll(Arrays.asList(n));
    }

    // ham xoa Minh Chung
    public void removeMinhChung(MinhChung minhChung) {
        this.dsMinhChung.remove(minhChung);
    }

    public TieuChuan getThuocTieuChuan() {
        return thuocTieuChuan;
    }

    public void setThuocTieuChuan(TieuChuan thuocTieuChuan) {
        this.thuocTieuChuan = thuocTieuChuan;
    }

    public ArrayList<MinhChung> getDsMinhChung() {
        return dsMinhChung;
    }

    public void setDsMinhChung(ArrayList<MinhChung> dsMinhChung) {
        this.dsMinhChung = dsMinhChung;
    }

}
