package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.MinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Arrays;

public class TieuChuan extends YeuCau {
    private static int contTieuChuan;
    private ArrayList<TieuChi> dsTieuChi;
    {
        setMaYeuCau(String.format("TC%05d", ++contTieuChuan));
    }
    public TieuChuan( String tenYeuCau, String noiDung) {
        super(null, tenYeuCau, noiDung);
        this.dsTieuChi = new ArrayList<>();
    }

    // ham them tieu chi
    public void addTieuChi(TieuChi... h) {
        this.dsTieuChi.addAll(Arrays.asList(h));
    }

    // ham xoa tieu chi
    public void removeTieuChi(TieuChi tieuChi) {
        this.dsTieuChi.remove(tieuChi);
    }

    public void removeTieuChi(String maTieuChi) {
        this.dsTieuChi.removeIf(x -> x.maYeuCau == maTieuChi);
    }

    @Override
    public void display() {
        System.out.printf("Ma Tieu Chuan : %s\n", getMaYeuCau());
        System.out.printf("Ten Tieu chuan : %s\n", getTenYeuCau());
        System.out.print("Danh sách tiêu chí:");
        if(this.dsTieuChi.size() ==0 ){
            System.out.println("Không có");
        }
        else{
            for (TieuChi tc : dsTieuChi) {
                System.out.printf(" - Ma Tieu Chi : %s \n", tc.getMaYeuCau());
                System.out.printf(" - Ten Tieu Chi : %s\n", tc.getTenYeuCau());
                if (tc.getDsMinhChung() == null || tc.getDsMinhChung().isEmpty()) {
                    System.out.println("- Tieu chi khong co danh sach minh chung");
                } else {
                    System.out.println("- Danh sach minh chung:");
                    for (int i = 0; i < tc.getDsMinhChung().size(); i++) {
                        System.out.println("  Minh chứng " + (i + 1) + ": ");
                        System.out.println(tc.getDsMinhChung().get(i));
                    }
                }

            }
        }
    }

    public ArrayList<TieuChi> getDsTieuChi() {
        return dsTieuChi;
    }

    public void setDsTieuChi(ArrayList<TieuChi> dsTieuChi) {
        this.dsTieuChi = dsTieuChi;
    }


}
