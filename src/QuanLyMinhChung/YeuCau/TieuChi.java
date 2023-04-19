package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class TieuChi extends YeuCau {
    private static int countTieuChi;

    private TieuChuan thuocTieuChuan;
    private ArrayList<MinhChung> dsMinhChung = new ArrayList<>();


    {
        setMaYeuCau(String.format("TChi%05d", ++countTieuChi));
    }

    public TieuChi(String tenYeuCau, String noiDung, TieuChuan tieuChuan) {
        super(null, tenYeuCau, noiDung);
        this.thuocTieuChuan = tieuChuan;
    }
    // ham Xoa minh Chung
    public void xoaMinhChung(TieuChi tieuChi, String tenMinhChungCanXoa) {
        ArrayList<MinhChung> dsMinhChung = tieuChi.getDsMinhChung();

        for (int i = 0; i < dsMinhChung.size(); i++) {
            MinhChung mc = dsMinhChung.get(i);
            if (mc.getTenMinhChung().equals(tenMinhChungCanXoa)) {
                dsMinhChung.remove(i);
                System.out.println("Đã xoá minh chứng " + tenMinhChungCanXoa + " khỏi tiêu chí " + tieuChi.getTenYeuCau());
                return;
            }
        }

        System.out.println("Không tìm thấy minh chứng " + tenMinhChungCanXoa + " trong tiêu chí " + tieuChi.getTenYeuCau());
    }

    public void sapXepMinhChungNgayBanHanh() {
        this.dsMinhChung.sort(Comparator.comparing(MinhChung::getNgayBanHanh));
    }

    public void displayTieuChi() {
        // Hiển thị Tiêu chí
        System.out.printf("| %-10s | %-5s |\n", getMaYeuCau(), getTenYeuCau());
        System.out.printf("| %-10s |\n", getNoiDung());

        // Hiển thị danh sách Minh chứng
        System.out.print("Danh sách Minh chứng \n");
        int index = 1;
        if(dsMinhChung.size()==0){
            System.out.println("Không có danh sách minh chứng ");
        }
        else{
            for (MinhChung minhChung : dsMinhChung) {
                System.out.printf("%d. %-10s - %-20s - %-15s - %-20s\n",
                        index++, minhChung.getMaMinhChung(),
                        minhChung.getTenMinhChung(),
                        CauHinh.f.format(minhChung.getNgayBanHanh()), minhChung.getNoiBanHanh());
            }
        }

    }

    //Kiem Tra Minh Chung da duoc them
    public boolean isCheckMinhChungAdd(MinhChung... minhChungs) {
        return this.dsMinhChung.contains(minhChungs);
    }

    // ham them Minh Chung
    public void addMinhChung(MinhChung... minhChungs) {
        if (!isCheckMinhChungAdd(minhChungs)) {
            this.dsMinhChung.addAll(Arrays.asList(minhChungs));
        } else {
            System.out.println("Minh chứng đã tồn tại trong danh sách");
        }
    }
    // ham xoa minh chung theo ten
    public boolean removeMinhChung(String kw) {
        this.dsMinhChung.removeIf(x ->{
            x.getTenMinhChung().contains(kw);
            return true;
        });
        return false;
    }
    public void showMinhChung(){
        dsMinhChung.forEach(e->e.display());
    }
    public boolean tonTai(MinhChung name){
        for(MinhChung e : this.dsMinhChung){
            if(e.equals(name)){
                return true;
            }
        }
        return false;
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
