package QuanLyMinhChung.User;

public class TruongPhong extends User {
    private boolean duocCapQuyen;
    public TruongPhong(String name, String pass) {
        super(name, pass);
        duocCapQuyen = false;
    }
    public TruongPhong(String name, String pass,boolean duocCapQuyen) {
        super(name, pass);
        this.duocCapQuyen = duocCapQuyen;
    }

    @Override
    public void display() {
        super.display();
        if(duocCapQuyen){
            System.out.print(" | Bạn được quyền thêm các nội dung và cấp quyền cho giảng viên \n");
        }else{
            System.out.print(" | Bạn không được quyền thêm các nội dung và cấp quyền cho giảng viên \n");
        }
    }
    public void capQuyen(){
        this.duocCapQuyen = !this.duocCapQuyen;
    }

    public boolean isDuocCapQuyen() {
        return duocCapQuyen;
    }

    public void setDuocCapQuyen(boolean duocCapQuyen) {
        this.duocCapQuyen = duocCapQuyen;
    }
}
