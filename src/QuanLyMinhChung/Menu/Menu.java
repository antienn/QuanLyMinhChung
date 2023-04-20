package QuanLyMinhChung.Menu;

import QuanLyMinhChung.BoKiemDinh.BoKiemDinh;
import QuanLyMinhChung.BoKiemDinh.QuanLyBoKiemDinh;
import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.CungCap.CungCap;
import QuanLyMinhChung.MinhChung.MinhChung;
import QuanLyMinhChung.MinhChung.QuanLiMinhChung;
import QuanLyMinhChung.PhongBan.PhongBan;
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
import java.util.NoSuchElementException;


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


        //hard code Tieu Chi Yeu Cau Tieu Chuan
        //=====================================================================================================//
        YeuCau tieuChuanIelts = new TieuChuan("4 kỹ năng","speaking,writing,reading,listening");
        YeuCau tieuChiItels  = new TieuChi("speaking","trên 6.5", (TieuChuan) tieuChuanIelts);

        YeuCau tieuChuanToiec = new TieuChuan("2 kỹ năng","speaking , reading");
        YeuCau tieuChiToiec = new TieuChi("reading","350point",(TieuChuan) tieuChuanToiec);

        YeuCau tieuChuanApplication = new TieuChuan("Tốt nghiệp","Giỏi , Khá , kỹ năng mềm");
        YeuCau tieuChiApplication = new TieuChi("kỹ năng mềm","GPA 6.5",(TieuChuan)tieuChuanApplication);

        YeuCau tieuChuanUpSalary = new TieuChuan("Thành công 3 dự án lớn","Kỹ năng , giấy tờ , báo cáo");
        YeuCau tieuChiUpSalary = new TieuChi("báo cáo","thuyết phục đề tài mới",(TieuChuan)tieuChuanUpSalary);
        YeuCau tieuChuanPhongCachNhaGiao = new TieuChuan("Bản đánh giá đảng viên cuối năm","Phiếu đánh giá đảng viên , Ảnh Giấy khen , báo cáo");
        YeuCau tieuChiPhongCachNhaGiao = new TieuChi("Phong cách nhà giáo","thuyết phục đề tài mới",(TieuChuan)tieuChuanPhongCachNhaGiao);

        QuanLyYeuCau dsYeuCau = new QuanLyYeuCau();
        dsYeuCau.addYeuCau(tieuChuanIelts,tieuChiItels,tieuChuanToiec,tieuChiToiec,tieuChuanApplication,tieuChiApplication,tieuChuanUpSalary,tieuChiUpSalary,tieuChuanPhongCachNhaGiao,tieuChiPhongCachNhaGiao);
        // hard code TieuChuan
        TieuChuan tieuChuanPhamChatNhaGiao = new TieuChuan("Phẩm chất nhà giáo:","Mức đạt Thực hiện nghiêm túc các quy định về đạo đức nhà giáo");
        TieuChuan tieuChuanChuyenMon = new TieuChuan("Phát triển chuyên môn, nghiệp vụ"," Xây dựng kế hoạch dạy học và giáo dục theo hướng phát triển phẩm chất, năng lực học sinh");
        TieuChuan tieuChuanXayDungMoiTruong = new TieuChuan("Xây dựng môi trường giáo dục","Xây dựng văn hóa nhà trường");
        TieuChuan tieuChuanSuDungNgoaiNgu = new TieuChuan("Sử dụng ngoại ngữ hoặc tiếng dân tộc","ứng dụng công nghệ thông tin, khai thác và sử dụng thiết bị công nghệ trong dạy học, giáo dục");
        TieuChuan tieuChuanHoTro = new TieuChuan("Hỗ trợ học sinh viên","Xét học bổng");
        //=====================================================================================================//
        // hard code MinhChung
        MinhChung minhChunDiemSo = new MinhChung("Điểm số","TPHCM","19/4/2023");
        MinhChung minhChungĐanhGiaGiangVien = new MinhChung("Trình Độ","Bộ giáo dục","20/8/2018");
        MinhChung minhChungUuTien = new MinhChung("ƯU TIÊN TRONG TUYỂN SINH","Bộ Giáo dục và Đào tạo" , "22/2/2020");
        MinhChung minhChungHoTro = new MinhChung("Kết quả học tập rèn luyện","Bộ giáo dục","20/04/2018");
        MinhChung minhChungSuDungCongTheThongTin = new MinhChung("Chứng chỉ Ngoại ngữ","Đại Học Mở","29/01/2016");
        MinhChung minhChungVanHoaNhaTruong = new MinhChung("Giấy chứng giáo viên dạy giỏi","THPT Nguyễn Công Trứ","12/07/2000");
        MinhChung minhChungPhatTrienChuyenMon = new MinhChung("Kế hoạch BDTX","Bộ Giáo dục và Đào tạo","20/4/2019");
        QuanLiMinhChung dsMinhChung = new QuanLiMinhChung();
        dsMinhChung.addMinhChung(minhChunDiemSo,minhChungĐanhGiaGiangVien,minhChungUuTien,minhChungHoTro,minhChungSuDungCongTheThongTin,minhChungVanHoaNhaTruong,minhChungPhatTrienChuyenMon);

        // hard code TieuChi
        TieuChi tieuChiSuDungNgoaiNgu = new TieuChi("Sử dụng Song Ngữ","Ngôn Ngữ",tieuChuanSuDungNgoaiNgu);
        TieuChi tieuChiChuyenMon = new TieuChi("Phát triển chuyên môn bản thân","Tư vấn và hỗ trợ học sinh",tieuChuanChuyenMon);
        TieuChi tieuChiDiemSo = new TieuChi("Phát triển điểm số học sinh","Cải cách quá trình dạy",tieuChuanXayDungMoiTruong);
        TieuChi tieuChiXoaBong = new TieuChi("Phát bổng ","Loại Giỏi",tieuChuanHoTro);
        TieuChi tieuChiBongSinhVienNgheo = new TieuChi("Phát bổng sinh viên","Khó khăn",tieuChuanHoTro);

        //hard code
        //
        //=====================================================================================================//
        // Hard Code Phong Ban
        PhongBan phongBanDiemSo = new PhongBan("Quan Lí điểm số","TPHCM");
        PhongBan phongBanUuTien = new PhongBan("Cung cấp và xác minh ưu Tiên","Bộ giáo Dục");
        PhongBan phongBanDieuHanhChuyenMon = new PhongBan("Đánh giá chuyên môn","Bộ Giaó Dục Hà Nội");
        PhongBan phongBanCapQuyenGiayTo = new PhongBan("Xác nhận xấy tờ ","Công Chứng Gò Vấp");
        PhongBan phongBanHoTroSinhVien = new PhongBan("Hỗ trợ sinh viên","Bộ giáo dục");
        PhongBan phongBanDanhGia = new PhongBan("Đánh giá chất lượng nhân viên","Nhà Nước");
        PhongBan phongBanThamQuyen = new PhongBan("Thẩm quyển các chức năng","Bộ Công An");
        // hard code CungCap
        CungCap cungCapDiemSo = new CungCap();
        cungCapDiemSo.ghiNhanCungCap(phongBanDiemSo,minhChunDiemSo,"20/8/2018","19/02/2018");
        cungCapDiemSo.ghiNhanCungCap(phongBanUuTien,minhChungHoTro,"20/8/2020","20/05/2023");
        //Tạo đối tượng
        Admin admin = new Admin();
        User u1 = new GiangVien("AnTien","123");
        User u2 = new TruongPhong("MinhTam","456",true);
        User u3 = new GiangVien("AnhTuan","999");
        User u4 = new GiangVien("HuuTu","666");
        User u5 = new TruongPhong("QuocTuan","777");
        QuanLyUser dsUser = new QuanLyUser();
        dsUser.addUser(u1,u2,u3,u4,u5);
        //Chương trình
        do{
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
                    System.out.print("Chon Chức Năng : ");
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
                            String tmpName;
                            boolean validName = false;
                            System.out.println("Danh sách Minh Chứng Hiện có : ");
                            dsMinhChung.displayMinhChung();
                            System.out.println("===============================");
                            do {
                               try{
                                   System.out.print("Bạn muốn biết thông tin minh chứng theo tên: ");
                                   tmpName = CauHinh.sc.nextLine();
                                   if (dsMinhChung.searchMinhChung(tmpName).isEmpty()) {
                                       System.out.println("Tên không hợp lệ. Vui lòng nhập lại.");
                                   } else {
                                       validName = true;
                                       dsMinhChung.searchMinhChung(tmpName).forEach(MinhChung::display);
                                   }
                               }catch (Exception exception){
                                   System.out.println("Tên không hợp lệ. Vui lòng nhập lại.");
                               }

                            } while (!validName);

                        }
                        case 5 -> {
                            boolean isValidInput = false;
                            System.out.println("Danh sách Minh Chứng Hiện có : ");
                            dsMinhChung.displayMinhChung();
                            System.out.println("===============================");
                            do {
                                try {
                                    System.out.print("Bạn muốn biết thông tin minh chứng theo cơ quan: ");
                                    String tmpCoQuan = CauHinh.sc.nextLine();
                                    if (dsMinhChung.searchMinhChungNoiBanHanh(tmpCoQuan).isEmpty()){
                                        System.out.println("Tên cơ quan  không hợp lệ. Vui lòng nhập lại.");
                                    }else {
                                        dsMinhChung.searchMinhChungNoiBanHanh(tmpCoQuan).forEach(MinhChung::display);
                                        isValidInput = true;
                                    }

                                } catch (Exception e) {
                                    System.out.println("Tên cơ quan  không hợp lệ. Vui lòng nhập lại.");
                                }

                            } while (!isValidInput);

                        }
                        case 6 -> {
                            do {
                                System.out.println("Danh sách Minh Chứng Hiện có : ");
                                dsMinhChung.displayMinhChung();
                                System.out.println("===============================");
                                System.out.print("Bạn muốn biết thông tin minh chứng theo ngày ban hành: ");
                                String tmpStringNgayBanHanh = CauHinh.sc.nextLine();
                                try {
                                    Date ngayBanHanh = CauHinh.f.parse(tmpStringNgayBanHanh);
                                    dsMinhChung.searchMinhChung(ngayBanHanh).forEach(MinhChung::display);
                                    break; // thoát khỏi vòng lặp nếu ngày hợp lệ
                                } catch (ParseException exception ) {
                                    System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                                }
                            } while (true);


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
                                    System.out.printf("Mời bạn nhập nội dung tiêu chuẩn %s :  ",tmptct);
                                    String tmptcnd = CauHinh.sc.nextLine();
                                    dsYeuCau.addYeuCau(new TieuChuan(tmptct,tmptcnd));
                                    System.out.println("Đã thêm thành công");
                                    break;
                                case 3:
                                    System.out.println("Mời bạn nhập tên tiêu chí bạn muốn tạo : ");
                                    String tmptchit = CauHinh.sc.nextLine();
                                    System.out.printf("Mời bạn nhập nội dung tiêu chí  %s : ",tmptchit);
                                    String tmptchind = CauHinh.sc.nextLine();
                                    dsYeuCau.displayTieuChuan();
                                    do {
                                        try {
                                            System.out.println("Mời bạn nhập tên tiêu chuẩn bạn muốn tạo");
                                            String tmptcthem = CauHinh.sc.nextLine();
                                            if(dsYeuCau.findTieuChuanByName(tmptcthem)!=null) {
                                                dsYeuCau.addYeuCau(new TieuChi(tmptchit,tmptchind, dsYeuCau.findTieuChuanByName(tmptcthem)));
                                                System.out.println("Đã thêm thành công");
                                                break;
                                            }
                                            else {
                                                System.out.println("Kkông tìm thấy ! Vui Lòng Nhập Lại");
                                            }

                                        } catch (Exception e) {
                                            System.out.println("Đã xảy ra lỗi. Vui lòng thử lại.");
                                        }
                                    } while(true);

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
                    System.out.println("Danh sách Tiêu Chí hiện tại:");
                    tmpGiangVien.getQhgv().tieuChiByGiangVien(tmpGiangVien.getQhgv()); // Hiển thị danh sách Tiêu Chí của giảng viên hiện tại
                    System.out.println("Mời bạn nhập tên Tiêu Chí bạn muốn chỉnh sửa: ");

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
                                System.out.println("danh sách minh chứng:");
                                dsMinhChung.displayMinhChung();
                                System.out.println("Mời bạn nhập tên minh chứng bạn muốn thêm:");
                                MinhChung tmpMinhChung = dsMinhChung.tonTai(CauHinh.sc.nextLine());
                                if(!tc.tonTai(tmpMinhChung)){
                                    tc.addMinhChung(tmpMinhChung);
                                    System.out.println("Thêm thành công!");
                                    System.out.println("Danh Sách hiện tại : ");
                                    tc.displayTieuChi();
                                }else{
                                    System.out.printf("Không thể thêm vào %s",tc.getTenYeuCau());
                                }
                                break;
                            case 3:
                                System.out.print("Nhap ten Minh Chung can xoa : ");
                                String tpmMinhChung = CauHinh.sc.nextLine();
                                if (tc.removeMinhChung(tpmMinhChung)){
                                    dsMinhChung.removeMinhChung(tpmMinhChung);
                                    System.out.println("Xoa Minh Chung Thanh cong");
                                }else{
                                    System.out.printf("Không tìm thấy minh chứng %s trong %s\n",tpmMinhChung,tc.getTenYeuCau() );
                                }
                                break;
                            case 4:
                                break;
                        }
                    }while (choose!=4);
                }

            }

        }while (!role.equals("TruongPhong") || !role.equals("Admin") || !role.equals("GiangVien"));
    }
}
