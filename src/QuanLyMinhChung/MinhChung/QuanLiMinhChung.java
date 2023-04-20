package QuanLyMinhChung.MinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.PhongBan.PhongBan;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class QuanLiMinhChung {
    private ArrayList<MinhChung> danhsachMinChung = new ArrayList<>();

    public ArrayList<MinhChung> getDanhsachMinChung() {
        return danhsachMinChung;
    }

    public void addMinhChung(MinhChung... dsMinhChung) {
        this.danhsachMinChung.addAll(Arrays.asList(dsMinhChung));
    }

    // Ham hien thi MinhChung
    // ghi de toString
    public void displayMinhChung() {
        boolean headerDisplayed = false;
        for (MinhChung mc : this.danhsachMinChung) {
            if (!headerDisplayed) {
                System.out.println(String.format("%-20s %-30s %-40s %-60s\n", "Mã Minh Chung", "Tên Minh Chung", "Nơi Ban Hành", "Ngày Ban Hành"));
                headerDisplayed = true;
            }
            System.out.println(mc.toString());
        }
    }

    //search Minh Chung theo ten;
    public List<MinhChung> searchMinhChung(String name) {
        return this.danhsachMinChung.stream().filter(x -> x.getTenMinhChung().contains(name)).collect(Collectors.toList());
    }

    //search Minh Chung theo ngay;
    public List<MinhChung> searchMinhChung(Date ngayBanHanh) {
        String ngayBanHanhStr = CauHinh.f.format(ngayBanHanh);
        return this.danhsachMinChung.stream()
                .filter(x -> CauHinh.f.format(x.getNgayBanHanh()).equals(ngayBanHanhStr))
                .collect(Collectors.toList());
    }
    public boolean removeMinhChung(String kw) {
        this.danhsachMinChung.removeIf(x ->{
            x.getTenMinhChung().contains(kw);
            return true;
        });
        return false;
    }

    public MinhChung tonTai(String name){
        for(MinhChung e : this.danhsachMinChung){
            if(e.getTenMinhChung().equals(name)){
                return e;
            }
        }
        return null;
    }

    //SearchMinhChung theo Phong ban
    public List<MinhChung> searchMinhChungByPhongBan(String tenPhongBan) {
        return this.danhsachMinChung.stream().filter(x -> {
            for(var y: x.getCungCapMinhChung()){
                if(y.getPhongBan().getTenPhongBan().equals(tenPhongBan)) return true;
            }
            return false;
        }).collect(Collectors.toList());
    }
    //Xep theo ngay Tao Minh Chung
    public void xepNgayTaoMinhChung(){
        this.danhsachMinChung.sort((mc1, mc2) -> mc1.getNgayBanHanh().compareTo(mc2.getNgayBanHanh()));
    }

    public void sapXepMinhChungTheoTen() {
        this.danhsachMinChung.sort(Comparator.comparing(MinhChung::getTenMinhChung));
    }


    public List<MinhChung> searchMinhChungNoiBanHanh(String noiBanHanh) {
        return this.danhsachMinChung.stream().filter(x -> x.getNoiBanHanh().contains(noiBanHanh)).collect(Collectors.toList());
    }

    public void setDanhsachMinChung(ArrayList<MinhChung> danhsachMinChung) {
        this.danhsachMinChung = danhsachMinChung;
    }



    //Ham them Minh CHung

}
