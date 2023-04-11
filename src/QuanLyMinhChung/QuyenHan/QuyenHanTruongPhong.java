package QuanLyMinhChung.QuyenHan;

import java.util.List;

public class QuyenHanTruongPhong {
    private boolean[] dsQuyenHan = {false,false,false,false};

    public QuyenHanTruongPhong(){

    }
    public void setRole(int num){
        if(!this.dsQuyenHan[num - 1]){
            this.dsQuyenHan[num-1] = true;
        }else{
            this.dsQuyenHan[num-1] = false;
        }
    }

    public boolean[] getDsQuyenHan() {
        return dsQuyenHan;
    }

    public void setDsQuyenHan(boolean[] dsQuyenHan) {
        this.dsQuyenHan = dsQuyenHan;
    }
}
