package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.MinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Arrays;

public class TieuChi extends YeuCau {
    private String maTieuChuan;
    private ArrayList<MinhChung> dsMinhChung;

    public TieuChi(String maYeuCau, String tenYeuCau, String noiDung, String maTieuChuan) {
        super(maYeuCau, tenYeuCau, noiDung);
        this.maTieuChuan = maTieuChuan;
        this.dsMinhChung = new ArrayList<>();
    }

    // ham them Minh Chung
    public void addMinhChung(MinhChung... n) {
        this.dsMinhChung.addAll(Arrays.asList(n));
    }

    // ham xoa Minh Chung
    public void removeMinhChung(MinhChung minhChung) {
        this.dsMinhChung.remove(minhChung);
    }


    public String getMaTieuChuan() {
        return maTieuChuan;
    }

    public void setMaTieuChuan(String maTieuChuan) {
        this.maTieuChuan = maTieuChuan;
    }

    public ArrayList<MinhChung> getDsMinhChung() {
        return dsMinhChung;
    }

    public void setDsMinhChung(ArrayList<MinhChung> dsMinhChung) {
        this.dsMinhChung = dsMinhChung;
    }

}
