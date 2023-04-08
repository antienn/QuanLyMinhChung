package QuanLyMinhChung.YeuCau;

public class YeuCau {

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

    public void display() {
        System.out.printf("Ma yeu cau : %s\n ", this.maYeuCau);
        System.out.printf("Ten Yeu Cau : %s\n ", this.tenYeuCau);
        System.out.printf("Noi dung Yeu Cau : %s\n ", this.noiDung);
    }

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
