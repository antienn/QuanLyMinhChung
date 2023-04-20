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
    public void displayTieuChi() {
        String format = "| %-10s | %-30s | %-50s |%n";
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
        System.out.format(format, "Mã Tiêu chí", "Tên Tiêu chí", "Nội dung Tiêu chí");
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChi")){
                System.out.format(format, yc.maYeuCau, yc.tenYeuCau, yc.noiDung);
            }
        }
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
    }

    public void displayTieuChuan(){
        String format = "| %-10s | %-30s | %-50s |%n";
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
        System.out.format(format, "Mã Tiêu Chuẩn", "Tên Tiêu Chuẩn", "Nội dung Tiêu Chuẩn");
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
        for(YeuCau yc : ds){
            if(yc.getClass().getSimpleName().equals("TieuChuan")){
                System.out.format(format, yc.maYeuCau, yc.tenYeuCau, yc.noiDung);
            }
        }
        System.out.format("+------------+--------------------------------+----------------------------------------------------+%n");
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
