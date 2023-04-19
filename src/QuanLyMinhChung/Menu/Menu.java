package QuanLyMinhChung.Menu;

import QuanLyMinhChung.BoKiemDinh.BoKiemDinh;
import QuanLyMinhChung.BoKiemDinh.QuanLyBoKiemDinh;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.User.GiangVien;
import QuanLyMinhChung.User.QuanLyUser;
import QuanLyMinhChung.User.TruongPhong;
import QuanLyMinhChung.User.User;
import QuanLyMinhChung.YeuCau.QuanLyYeuCau;
import QuanLyMinhChung.YeuCau.TieuChi;
import QuanLyMinhChung.YeuCau.TieuChuan;
import QuanLyMinhChung.YeuCau.YeuCau;
import QuanLyMinhChung.admin.Admin;

import java.text.ParseException;
import java.util.Date;


public class Menu {
    public static void main(String[] args) throws ParseException {
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
        YeuCau c = new TieuChi("speaking","trên 6.5", (TieuChuan) b);
        QuanLyYeuCau dsYeuCau = new QuanLyYeuCau();
        dsYeuCau.addYeuCau(b,c);

        MinhChung d = new MinhChung("Điểm số","TPHCM","19/4/2023");
        QuanLiMinhChung dsMinhChung = new QuanLiMinhChung();
        dsMinhChung.addMinhChung(d);
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
                System.out.println("4/Tìm kiếm minh chứng theo tên");
                System.out.println("5/Tìm kiếm minh chứng theo cơ quan");
                System.out.println("6/Tìm kiếm minh chứng theo ngày ban hành");
                System.out.println("7/Tìm kiếm minh chứng theo phòng ban cung cấp");
                System.out.println("8/thoát");
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
                    case 4 -> {
                        System.out.print("Bạn muốn biết thông tin minh chứng theo tên: ");
                        String tmpName = CauHinh.sc.nextLine();
                        dsMinhChung.searchMinhChung(tmpName).forEach(MinhChung::display);
                    }
                    case 5 -> {
                        System.out.print("Bạn muốn biết thông tin minh chứng theo cơ quan: ");
                        String tmpCoQuan = CauHinh.sc.nextLine();
                        dsMinhChung.searchMinhChungNoiBanHanh(tmpCoQuan).forEach(MinhChung::display);
                    }
                    case 6 -> {
                        System.out.print("Bạn muốn biết thông tin minh chứng theo ngày ban hành: ");
                        String tmpStringNgayBanHanh = CauHinh.sc.nextLine();
                        Date ngayBanHanh = CauHinh.f.parse(tmpStringNgayBanHanh);
                        dsMinhChung.searchMinhChung(ngayBanHanh).forEach(MinhChung::display);
                    }
                    case 7 -> {

                    }
                    case 8 -> System.out.println("Đã đăng suất thành công");
                    default -> System.out.println("Lỗi truy cập");
                }
            }while(choose !=8);
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
                                        break;
                                    }
                                }while(true);
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
                GiangVien tmpGiangVien = (GiangVien) tmp;
                ((GiangVien) tmp).getQhgv().show();
                System.out.println("Mời bạn nhập tên tiêu chí bạn muốn chỉnh sửa : ");
                TieuChi tc;
                do{
                    String tmptchit = CauHinh.sc.nextLine();
                    if(tmpGiangVien.getQhgv().findTieuChi(tmptchit) != null){
                        tc = tmpGiangVien.getQhgv().findTieuChi(tmptchit);
                        break;
                    }else{
                        System.out.printf("Tên %s bạn nhập không có trong danh sách tiêu chí bạn muốn chỉnh sửa : ",tmptchit);
                    }
                }while (true);
                do {
                    System.out.println("Bạn muốn thêm Minh Chứng mới hay cập nhật Minh Chứng có sẵn?");
                    System.out.println("1. Thêm mới");
                    System.out.println("2. Cập nhật Minh Chứng có sẵn");
                    System.out.println("3. Xoa Minh chung");
                    System.out.println("4. Thoat");

                    System.out.print("- Chọn chức năng: ");
                    choose = CauHinh.sc.nextInt();
                    CauHinh.sc.nextLine(); // Đọc ký tự '\n' sau khi nhập số integer
                    switch (choose){
                        case 1:{
                            System.out.print("Nhập tên Minh Chứng mới: ");
                            String tenMinhChung = CauHinh.sc.nextLine();
                            System.out.print("Nhập nơi ban hành: ");
                            String noiBanHanh = CauHinh.sc.nextLine();
                            System.out.println("Nhap ngay ban hanh moi (dd/MM/yyyy):");
                            Date ngayBanHanhMoi = null;
                            try {
                                ngayBanHanhMoi = CauHinh.f.parse(CauHinh.sc.nextLine());
                                MinhChung newMinhChung = new MinhChung(tenMinhChung,noiBanHanh,CauHinh.f.format(ngayBanHanhMoi));
                                dsMinhChung.addMinhChung(newMinhChung);
                                tc.addMinhChung(newMinhChung);
                            } catch (ParseException e) {
                                System.out.println("Ngay ban hanh khong hop le.");
                            }
                            break;
                        }
                        case 2:
                            System.out.println(tc.getTenYeuCau());
                            tc.showMinhChung();
                            System.out.println("danh sách minh chứng:");
                            dsMinhChung.display();
                            System.out.println("Mời bạn nhập tên minh chứng bạn muốn thêm:");
                            MinhChung tmpMinhChung = dsMinhChung.tonTai(CauHinh.sc.nextLine());
                            if(!tc.tonTai(tmpMinhChung)){
                                tc.addMinhChung(tmpMinhChung);
                                System.out.println("Thêm thành công!");
                            }else{
                                System.out.printf("Không thể thêm vào %s",tc.getTenYeuCau());
                            }
                        case 3:
                            System.out.print("Nhap ten Minh Chung can xoa : ");
                            String tpmMinhChung = CauHinh.sc.nextLine();
                            if (tc.removeMinhChung(tpmMinhChung)){
                                dsMinhChung.removeMinhChung(tpmMinhChung);
                                System.out.println("Xoa Minh Chung Thanh cong");
                            }else{
                                System.out.printf("Không tìm thấy minh chứng %s trong %s",tpmMinhChung,tc.getTenYeuCau() );
                            }
                            break;
                        case 4:
                            break;
                    }
                }while (choose!=4);
            }

        }
    }
}
