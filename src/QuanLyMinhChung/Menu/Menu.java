package QuanLyMinhChung.Menu;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.User.GiangVien;
import QuanLyMinhChung.User.QuanLyUser;
import QuanLyMinhChung.User.TruongPhong;
import QuanLyMinhChung.User.User;
import QuanLyMinhChung.YeuCau.QuanLyYeuCau;
import QuanLyMinhChung.admin.Admin;


public class Menu {
    public static void main(String[] args) throws ClassNotFoundException {
        //biến toàn cục
        String role = null;
        int choose;
        //Tạo đối tượng
        Admin admin = new Admin();
        User u1 = new GiangVien("AnTien","123");
        User u2 = new TruongPhong("MinhTam","456");

        QuanLyYeuCau dsYeuCau = new QuanLyYeuCau();
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
            do{
                System.out.println("=========MENU========");
                System.out.println("1/Hiển thị danh sách user");
                System.out.println("2/Tạo tài khoản");
                System.out.println("3/Cấp quyền cho giảng viên");
                System.out.println("4/Cấp quyền cho trưởng phòng");
                System.out.println("5/thoát");
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
                        dsUser.dsGiangVien().forEach(GiangVien::display);
                        String tmpname = CauHinh.sc.nextLine();
                        GiangVien tmpGV = (GiangVien) dsUser.findUserByName(tmpname);
                        if(tmpGV==null){
                            System.out.println("Không tìm thấy tên");
                            break;
                        }
                        System.out.println("1/Cấp quyền biên soạn nội dung tiêu chí");
                        System.out.println("2/Cấp quyền chỉnh sửa tiêu chí");
                        int chooseRoleGV  = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (chooseRoleGV){
                            case 1:
                                tmpGV.getQhgv().setDuocBienSoanTieuChi(true);
                                break;
                            case 2:
                                break;
                            default: System.out.println("Lỗi truy cập");
                        }
                    }
                    case 4:
                        dsUser.dsTruongPhong().forEach(TruongPhong::display);
                        String tmpname = CauHinh.sc.nextLine();
                        int chooseRole = Integer.parseInt( CauHinh.sc.nextLine());
                        if(chooseRole > 4 ||chooseRole < 1){
                            System.out.println("Quyền không tồn tại");
                            break;
                        }
                        TruongPhong tmpTP = (TruongPhong)dsUser.findUserByName(tmpname);
                        if(tmpTP!=null){
                            tmpTP.setQhtp(chooseRole);
                            System.out.println("Cấp quyền thành công");
                        }else{
                            System.out.println("Không tìm thấy tên");
                        }
                        break;
                    case 5:
                        System.out.println("Đã đăng suất thành công");
                        break;
                    default: System.out.println("Lỗi truy cập");
                }
            }while(choose !=5);
        }
        if(role.equals("User")){

        }
    }
}
