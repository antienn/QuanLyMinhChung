package QuanLyMinhChung.Menu;

import QuanLyMinhChung.CauHinh.BoPhan;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CauHinh.ThaoTac;
import QuanLyMinhChung.User.GiangVien;
import QuanLyMinhChung.User.QuanLyUser;
import QuanLyMinhChung.User.TruongPhong;
import QuanLyMinhChung.User.User;
import QuanLyMinhChung.admin.Admin;


public class Menu {
    public static void main(String[] args)  {
        //biến toàn cục
        String role = null;
        //Tạo đối tượng
        Admin admin = new Admin();
        User u1 = new GiangVien("AnTien","123");
        User u2 = new TruongPhong("MinhTam","456");

        u1.themQuyenHan(BoPhan.BOKIEMDINH,ThaoTac.XOA);
        u1.themQuyenHan(BoPhan.MINHCHUNG,ThaoTac.THEM);
        u2.themQuyenHan(BoPhan.MINHCHUNG,ThaoTac.CHINHSUA);

        QuanLyUser dsUser = new QuanLyUser();
        dsUser.addUser(u1,u2);
        //Chương trình
        do{
            System.out.print("Tên đăng nhập:");
            String tmpUser = CauHinh.sc.nextLine();
            System.out.print("Mật khẩu:");
            String tmpPass = CauHinh.sc.nextLine();
            role = admin.isAdmin(tmpUser,tmpPass);
            if(role == null){
                role = dsUser.checkRole(tmpUser,tmpPass);
            }
            if(role!=null){
                break;
            }else{
                System.out.println("Tên đăng nhập hoặc mật khẩu không đúng");
            }
        }while(true);
        if(role.equals("Admin")){
            int choose;
            do{
                System.out.println("1/Hiển thị danh sách user");
                System.out.println("2/Tạo tài khoản");
                System.out.println("3/Cấp quyền cho đối tượng");
                System.out.println("4/thoát");
                choose = Integer.parseInt(CauHinh.sc.nextLine());
                switch (choose){
                    case 1: dsUser.display();break;
                    case 2: {
                        User newUser = null;
                        System.out.print("Tên đăng nhập:");
                        String newName = CauHinh.sc.nextLine();
                        System.out.print("Mật khẩu:");
                        String newPass = CauHinh.sc.nextLine();
                        System.out.print("role(GiangVien or TruongPhong):");
                        String newRole = CauHinh.sc.nextLine();
                        if(newRole.equals("GiangVien")){
                            newUser = new GiangVien(newName,newPass);
                        }
                        if(newRole.equals("TruongPhong")){
                            newUser = new TruongPhong(newName,newPass);
                        }
                        if(newUser != null){
                            dsUser.addUser(newUser);
                            System.out.println("tạo tài khoản thành công");
                        }else{
                            System.out.println("tạo tài khoản thất bại");
                        }
                        break;
                    }
                    case 3:{
                        User tmpUser;
                        BoPhan nd;
                        ThaoTac tt;
                        dsUser.display();
                        System.out.println("Mời bạn nhập tên người muốn cấp quyền");
                        String name = CauHinh.sc.nextLine();
                        tmpUser = dsUser.findUserByName(name);
                        if(tmpUser != null){
                            tmpUser.hienThiDanhSachQuyenHan();
                            System.out.printf("1/Thêm \n2/xóa \n3/Chỉnh sửa \nBạn muốn cấp thao tác:");
                            tt = ThaoTac.valueOf(CauHinh.sc.nextLine().toUpperCase());
                            System.out.printf("1/Bộ Kiểm Định \n2/Tiêu Chuẩn \n3/Tiêu Chí \n4/Minh Chứng \nBạn muốn cấp thao tác nội dung gì:");
                            nd = BoPhan.valueOf(CauHinh.sc.nextLine().toUpperCase());
                            tmpUser.themQuyenHan(nd,tt);
                        }else{
                            System.out.println("Không tìm thấy tên");
                        }

                    }
                    case 4:
                        System.out.println("Đã đăng suất thành công");
                        break;
                    default: System.out.println("Lỗi truy cập");
                }
            }while(true);
        }else{

        }
    }
}
