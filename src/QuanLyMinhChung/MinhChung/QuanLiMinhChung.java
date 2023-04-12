package QuanLyMinhChung.MinhChung;

import QuanLyMinhChung.CauHinh.CauHinh;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class QuanLiMinhChung {
    private ArrayList<MinhChung> danhsachMinChung = new ArrayList<>();

    public ArrayList<MinhChung> getDanhsachMinChung() {
        return danhsachMinChung;
    }
    //search Minh Chung theo ten;
    public List<MinhChung> searchMinhChung(String name){
        return   this.danhsachMinChung.stream().filter(x->x.getTenMinhChung().contains(name)).collect(Collectors.toList());
    }

    //search Minh Chung theo ngay;
    public List<MinhChung> searchMinhChung(Date ngayBanHanh) {
        String ngayBanHanhStr = CauHinh.f.format(ngayBanHanh);
        return this.danhsachMinChung.stream()
                .filter(x -> CauHinh.f.format(x.getNgayBanHanh()).equals(ngayBanHanhStr))
                .collect(Collectors.toList());
    }
    public void sapXepMinhChungTheoTen() {
        this.danhsachMinChung.sort(Comparator.comparing(MinhChung::getTenMinhChung));
    }
    //search Minh Chung theo phong Ban
    public void nhapMinhChung(){
        this.danhsachMinChung.forEach(h->h.nhapThongTinChung());
    }
    public List<MinhChung> searchMinhChungNoiBanHanh(String noiBanHanh){
        return   this.danhsachMinChung.stream().filter(x->x.getNoiBanHanh().contains(noiBanHanh)).collect(Collectors.toList());
    }
    public void setDanhsachMinChung(ArrayList<MinhChung> danhsachMinChung) {
        this.danhsachMinChung = danhsachMinChung;
    }
    public void display(){
        this.danhsachMinChung.forEach(h->h.display());
    }


    //Ham them Minh CHung
    public void addMinhChung(MinhChung ...dsMinhChung){
        this.danhsachMinChung.addAll(Arrays.asList(dsMinhChung));
    }
    // Ham hien thi MinhChung
    // ghi de toString
    public void displayMinhChung(){
        this.danhsachMinChung.forEach(x -> System.out.println(x));
    }

}
