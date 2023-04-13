package QuanLyMinhChung.BoKiemDinh;

import QuanLyMinhChung.MinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public BoKiemDinh searchBoKiemDinh(String name) {
        for (BoKiemDinh bkd : dsBoKiemDinh) {
            if (bkd.getTenBoKiemDinh().equals(name)) {
                return bkd;
            }
        }
        return null;
    }
}
