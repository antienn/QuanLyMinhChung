package QuanLyMinhChung.BoKiemDinh;

import java.util.ArrayList;
import java.util.Arrays;

public class QuanLyBoKiemDinh {
    private ArrayList<BoKiemDinh> dsBoKiemDinh = new ArrayList<>();
    public void addBoKiemDinh(BoKiemDinh ... boKiemDinhs){
        this.dsBoKiemDinh.addAll(Arrays.asList(boKiemDinhs));
    }
    public  void diplayBoKiemDinh(){
        this.dsBoKiemDinh.forEach(h->h.display());
    }
    public ArrayList<BoKiemDinh> getDsBoKiemDinh() {
        return dsBoKiemDinh;
    }

    public void setDsBoKiemDinh(ArrayList<BoKiemDinh> dsBoKiemDinh) {
        this.dsBoKiemDinh = dsBoKiemDinh;
    }
}
