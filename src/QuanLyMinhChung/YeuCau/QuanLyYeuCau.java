package QuanLyMinhChung.YeuCau;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

public class QuanLyYeuCau {
    private ArrayList<YeuCau> dsYeuCau = new ArrayList<>();
    private ArrayList<TieuChuan> dsTieuChuan = new ArrayList<>();

    public ArrayList<YeuCau> getDsYeuCau() {
        return dsYeuCau;
    }

    public void addListTieuChuan(TieuChuan... tcs) {
        this.dsTieuChuan.addAll(Arrays.asList(tcs));
    }


    public void removeTieuChuan(String maTieuChuan) {
        this.dsTieuChuan.removeIf(x -> x.getMaYeuCau() == maTieuChuan);
    }

    public void removeTieuChuan(TieuChuan tc) {
        this.dsTieuChuan.remove(tc);
    }

    public void displayTieuChuan(){
        this.dsTieuChuan.forEach(h-> h.display());
    }

    public void addYeuCau(YeuCau... yc) {
        this.dsYeuCau.addAll(Arrays.asList(yc));
    }

    public void setDsYeuCau(ArrayList<YeuCau> dsYeuCau) {
        this.dsYeuCau = dsYeuCau;
    }


}
