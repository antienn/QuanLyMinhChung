package QuanLyMinhChung.PhongBan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyPhongBan {
    List<PhongBan> dsPhongBan = new ArrayList<>();

    public void addPhongBan(PhongBan ... PhongBans){
        this.dsPhongBan.addAll(Arrays.asList(PhongBans));
    }
    public PhongBan findPhongBanByName(String name){
        for(PhongBan pb : dsPhongBan){
            if(pb.getTenPhongBan().equals(name)){
                return pb;
            }
        }
        return null;
    }
}
