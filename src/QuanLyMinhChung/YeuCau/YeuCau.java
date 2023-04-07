package QuanLyMinhChung.YeuCau;

public class YeuCau {
    private String maTieuChuan;
    private String tenTieuChuan;
    private String NoiDung;
    public YeuCau(String maTieuChuan, String tenTieuChuan, String noiDung) {
        this.maTieuChuan = maTieuChuan;
        this.tenTieuChuan = tenTieuChuan;
        NoiDung = noiDung;
    }

    public String getMaTieuChuan() {
        return maTieuChuan;
    }

    public void setMaTieuChuan(String maTieuChuan) {
        this.maTieuChuan = maTieuChuan;
    }

    public String getTenTieuChuan() {
        return tenTieuChuan;
    }

    public void setTenTieuChuan(String tenTieuChuan) {
        this.tenTieuChuan = tenTieuChuan;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }


}
