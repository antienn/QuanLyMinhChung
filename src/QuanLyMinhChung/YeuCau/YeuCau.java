package QuanLyMinhChung.YeuCau;

public abstract class YeuCau {
    protected String maYeuCau;
    protected String tenYeuCau;
    protected String noiDung;


    public YeuCau(String maYeuCau, String tenYeuCau, String noiDung) {
        this.maYeuCau = maYeuCau;
        this.tenYeuCau = tenYeuCau;
        this.noiDung = noiDung;
    }

    public String getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(String maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getTenYeuCau() {
        return tenYeuCau;
    }

    public abstract void display();

    public void setTenYeuCau(String tenYeuCau) {
        this.tenYeuCau = tenYeuCau;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }


}
