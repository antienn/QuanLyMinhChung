package QuanLyMinhChung.MinhChung;

import java.util.ArrayList;
import java.util.Arrays;

public class QuanLiMinhChung {
    private ArrayList<MinhChung> danhsachMinChung = new ArrayList<>();

    //Ham them Minh CHung
    public void addMinhChung(MinhChung ...dsMinhChung){
        this.danhsachMinChung.addAll(Arrays.asList(dsMinhChung));
    }
    // Ham hien thi MinhChung
    public void displayMinhChung(){
        this.danhsachMinChung.forEach(x -> System.out.println(x));
    }

}
