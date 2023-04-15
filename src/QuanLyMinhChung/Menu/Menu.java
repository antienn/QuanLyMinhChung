package QuanLyMinhChung.Menu;

import QuanLyMinhChung.BoKiemDinh.BoKiemDinh;
import QuanLyMinhChung.BoKiemDinh.QuanLyBoKiemDinh;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.User.GiangVien;
import QuanLyMinhChung.User.QuanLyUser;
import QuanLyMinhChung.User.TruongPhong;
import QuanLyMinhChung.User.User;
import QuanLyMinhChung.YeuCau.QuanLyYeuCau;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.TieuChuan;
import QuanLyMinhChung.YeuCau.YeuCau;
import QuanLyMinhChung.admin.Admin;


public class Menu {
    public static void main(String[] args) throws ClassNotFoundException {
        //biến toàn cục
        String role = null;
        User tmp;
        GiangVien gv;
        int choose;

        //Tạo nghiệp vụ
        BoKiemDinh a = new BoKiemDinh("Ielts");
        QuanLyBoKiemDinh dsBoKiemDinh = new QuanLyBoKiemDinh();
        dsBoKiemDinh.addBoKiemDinh(a);

        YeuCau b = new TieuChuan("4 kỹ năng","speaking,writing,reading,listening");
        QuanLyYeuCau dsYeuCau = new QuanLyYeuCau();
        dsYeuCau.addYeuCau(b);
        //Tạo đối tượng
        Admin admin = new Admin();
        User u1 = new GiangVien("AnTien","123");
        User u2 = new TruongPhong("MinhTam","456",true);

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
                tmp = dsUser.findUserByName(tmpUser);
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
                System.out.println("3/Cấp quyền cho trưởng phòng");
                System.out.println("4/thoát");
                choose = Integer.parseInt(CauHinh.sc.nextLine());
                switch (choose) {
                    case 1 -> dsUser.display();
                    case 2 -> {
                        User newUser = null;
                        System.out.print("Tên đăng nhập:");
                        String newName = CauHinh.sc.nextLine();
                        System.out.print("Mật khẩu:");
                        String newPass = CauHinh.sc.nextLine();
                        System.out.print("role(GiangVien or TruongPhong):");
                        String newRole = CauHinh.sc.nextLine();
                        if (newRole.equals("GiangVien")) {
                            newUser = new GiangVien(newName, newPass);
                        }
                        if (newRole.equals("TruongPhong")) {
                            newUser = new TruongPhong(newName, newPass);
                        }
                        if (newUser != null) {
                            dsUser.addUser(newUser);
                            System.out.println("tạo tài khoản thành công");
                        } else {
                            System.out.println("tạo tài khoản thất bại");
                        }
                        break;
                    }
                    case 3 -> {
                        dsUser.dsTruongPhong().forEach(TruongPhong::display);
                        System.out.print("Nhap ten Truong Phong can cap quyền : ");
                        String tmpname = CauHinh.sc.nextLine();
                        int chooseRole = Integer.parseInt(CauHinh.sc.nextLine());
                        if (chooseRole > 4 || chooseRole < 1) {
                            System.out.println("Quyền không tồn tại");
                            break;
                        }
                        TruongPhong tmpTP = (TruongPhong) dsUser.findUserByName(tmpname);
                        if (tmpTP != null) {
                            tmpTP.capQuyen();
                            System.out.println("Cấp quyền thành công");
                        } else {
                            System.out.println("Không tìm thấy tên");
                        }
                    }
                    case 4 -> System.out.println("Đã đăng suất thành công");
                    default -> System.out.println("Lỗi truy cập");
                }
            }while(choose !=4);
        }
        else{
            if(role.equals("TruongPhong")){
                TruongPhong tmpTruongPhong = (TruongPhong) tmp;
                tmpTruongPhong.display();
                if(!tmpTruongPhong.isDuocCapQuyen()){
                    System.out.println("Hãy yêu cầu admin cấp quyền cho bạn");
                }else{
                    do {
                        System.out.println("1/Quản lý bộ kiểm định");
                        System.out.println("2/Quản lý Tiêu chuẩn");
                        System.out.println("3/Quản lý Tiêu chí");
                        System.out.println("4/Thêm quyền cho giảng viên");
                        System.out.println("5/thoát");
                        choose = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (choose){
                            case 1:
                                System.out.println("1/Tạo bộ kiểm định : ");
                                System.out.println("2/Thêm tiêu chuẩn vào bộ kiểm định : ");
                                choose = Integer.parseInt(CauHinh.sc.nextLine());
                                if(choose == 1 || choose ==2){
                                    if(choose == 1 ){
                                        System.out.println("Nhập tên bộ kiểm định bạn muốn tạo : ");
                                        BoKiemDinh tmpBKD = new BoKiemDinh(CauHinh.sc.nextLine());
                                        dsBoKiemDinh.addBoKiemDinh(tmpBKD);
                                    }else{
                                        dsYeuCau.displayTieuChuan();
                                        System.out.println("Mời bạn nhập tên tiêu chuẩn muốn thêm : ");
                                        String tmpTc = CauHinh.sc.nextLine();
                                        dsBoKiemDinh.diplayBoKiemDinh();
                                        System.out.printf("Mời bạn nhập tên bộ kiểm định muốn thêm %s vào danh sach \n",tmpTc);
                                        String tmpbkd = CauHinh.sc.nextLine();
                                        dsBoKiemDinh.searchBoKiemDinh(tmpbkd).addTieuChuan(dsYeuCau.findTieuChuanByName(tmpTc));
                                        dsBoKiemDinh.diplayBoKiemDinh();
                                        break;
                                    }
                                }else{
                                    System.out.println("lỗi chọn");
                                }
                            case 2:
                                System.out.println("Mời bạn nhập tên tiêu chuẩn bạn muốn tạo : ");
                                String tmptct = CauHinh.sc.nextLine();
                                System.out.printf("Mời bạn nhập nội dung tiêu chuẩn :  %s",tmptct);
                                String tmptcnd = CauHinh.sc.nextLine();
                                dsYeuCau.addYeuCau(new TieuChuan(tmptct,tmptcnd));
                                System.out.println("Đã thêm thành công");
                                break;
                            case 3:
                                boolean found = false;
                                System.out.println("Mời bạn nhập tên tiêu chí bạn muốn tạo : ");
                                String tmptchit = CauHinh.sc.nextLine();
                                System.out.printf("Mời bạn nhập nội dung tiêu chí :  %s",tmptchit);
                                String tmptchind = CauHinh.sc.nextLine();
                                do{
                                    dsYeuCau.displayTieuChuan();
                                    System.out.println("Mời bạn nhập tên tiêu chuẩn bạn muốn tạo");
                                    String tmptcthem = CauHinh.sc.nextLine();
                                    if(dsYeuCau.findTieuChuanByName(tmptcthem)!=null) {
                                        dsYeuCau.addYeuCau(new TieuChi(tmptchit,tmptchind, dsYeuCau.findTieuChuanByName(tmptcthem)));
                                        System.out.println("Đã thêm thành công");
                                        found = true;
                                        break;
                                    }
                                }while(!found);
                                break;
                            case 4:
                                dsUser.dsGiangVien().forEach(GiangVien::display);
                                do{
                                    System.out.println("Mời bạn nhập tên giảng viên bạn muốn cấp quyền");
                                    String tmpgvten = CauHinh.sc.nextLine();
                                    if(dsUser.findUserByName(tmpgvten)!=null){
                                        gv = (GiangVien) dsUser.findUserByName(tmpgvten);
                                        break;
                                    }else{
                                        System.out.println("Không tìm thấy tên giảng viên");
                                    }
                                }while (true);
                                System.out.println("1/cấp quyền cho giảng viên gắn minh chứng cho tiêu chí ");
                                System.out.println("2/ cấp quyền soạn tiêu chí");
                                choose = Integer.parseInt(CauHinh.sc.nextLine());
                                if(choose == 1 || choose == 2 ){
                                    if(choose == 1){
                                        dsYeuCau.displayTieuChi();
                                        System.out.println("Mời bạn nhập tên tiêu chí muốn cấp quyền cho giảng viên");
                                        String tmpten = CauHinh.sc.nextLine();
                                        if(dsYeuCau.findTieuChiByName(tmpten)!=null){
                                            gv.getQhgv().addTieuChi(dsYeuCau.findTieuChiByName(tmpten));
                                            System.out.println("Cấp quyền thành công");
                                        }else{
                                            System.out.printf("Tiêu chí %s không tồn tại",tmpten);
                                        }
                                    }else{
                                        gv.getQhgv().setDuocBienSoanTieuChi();
                                        System.out.println("Cấp quyền thành công");
                                    }
                                }else{
                                    System.out.println("Lỗi chọn");
                                }
                                break;
                            case 5:
                                System.out.println("đăng xuất thành công");
                                break;

                        }
                    }while (choose!=5);
                }

            }else{
                do{
                    System.out.println("1/Chỉnh sửa tiêu chí");
                    System.out.println("2/Biên soạn tiêu chí");
                    choose = Integer.parseInt(CauHinh.sc.nextLine());
                }while (choose !=2);
            }
        }
    }
}
