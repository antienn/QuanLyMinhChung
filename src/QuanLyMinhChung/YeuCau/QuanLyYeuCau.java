package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.MinhChung.MinhChung;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

public class QuanLyYeuCau {
    private ArrayList<YeuCau> ds = new ArrayList<>();

    public void addYeuCau(YeuCau ...dsYeuCau){
        this.ds.addAll(Arrays.asList(dsYeuCau));
    }
    public void displayTieuChi(){
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChi")){
                yc.display();
            }
        }
    }
    public void displayTieuChuan(){
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChuan")){
                yc.display();
            }
        }
    }
    public TieuChuan findTieuChuanByName(String name){
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChuan") && yc.getTenYeuCau().equals(name)){
                return (TieuChuan) yc;
            }
        }
        return null;
    }
    public TieuChi findTieuChiByName(String name){
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChi") && yc.getTenYeuCau().equals(name)){
                return (TieuChi) yc;
            }
        }
        return null;
    }
}
