package QuanLyMinhChung.User;

import QuanLyMinhChung.CauHinh.BoPhan;
import QuanLyMinhChung.CauHinh.ThaoTac;
import QuanLyMinhChung.QuyenHan.QuyenHan;

import java.util.ArrayList;

public class User {

    private static int count;
    private String id;
    private String name;
    private String pass;

    private final ArrayList<QuyenHan> danhSachQuyenHan = new ArrayList<>();

    {
        this.id = String.format("User%05d",++count);
    }
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public boolean isUser(String name, String pass) {
        return this.name.equals(name) && this.pass.equals(pass);
    }
    public void display(){
        System.out.printf("%s | %s |%s\n",this.id,this.name,this.getClass().getSimpleName());
        this.hienThiDanhSachQuyenHan();
    }

    public static User createUser(String name,String pass,String role){
        if(role.equals("GiangVien")){
            return new GiangVien(name,pass);
        }
        if(role.equals("TruongPhong")){
            return new TruongPhong(name,pass);
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<QuyenHan> getDanhSachQuyenHan() {
        return danhSachQuyenHan;
    }
    public void themQuyenHan(BoPhan noidung, ThaoTac tuongtac){

        this.danhSachQuyenHan.add(new QuyenHan(noidung,tuongtac));
    }
    public void hienThiDanhSachQuyenHan(){
        if(this.getDanhSachQuyenHan().isEmpty()){
            System.out.println("Thành viên này chưa có quyền \n");
        }else {
            System.out.print("====Danh Sách Quyền Hạn=== \n");
            this.danhSachQuyenHan.forEach(QuyenHan::show);
        }
    }


}
