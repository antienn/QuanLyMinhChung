package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class TieuChi extends YeuCau {
    private static int countTieuChi;

    private TieuChuan thuocTieuChuan;
    private ArrayList<MinhChung> dsMinhChung = new ArrayList<>();


    {
        setMaYeuCau(String.format("TChi%05d", ++countTieuChi));
    }

    public TieuChi(String tenYeuCau, String noiDung, TieuChuan tieuChuan) {
        super(null, tenYeuCau, noiDung);
        this.thuocTieuChuan = tieuChuan;
    }
    // ham Xoa minh Chung
    public void xoaMinhChung(TieuChi tieuChi, String tenMinhChungCanXoa) {
        ArrayList<MinhChung> dsMinhChung = tieuChi.getDsMinhChung();

        for (int i = 0; i < dsMinhChung.size(); i++) {
            MinhChung mc = dsMinhChung.get(i);
            if (mc.getTenMinhChung().equals(tenMinhChungCanXoa)) {
                dsMinhChung.remove(i);
                System.out.println("Đã xoá minh chứng " + tenMinhChungCanXoa + " khỏi tiêu chí " + tieuChi.getTenYeuCau());
                return;
            }
        }

        System.out.println("Không tìm thấy minh chứng " + tenMinhChungCanXoa + " trong tiêu chí " + tieuChi.getTenYeuCau());
    }

    public void sapXepMinhChungNgayBanHanh() {
        this.dsMinhChung.sort(Comparator.comparing(MinhChung::getNgayBanHanh));
    }

    public void displayTieuChi() {
        // Hiển thị Tiêu chí
        System.out.printf("| %-10s | %-5s |\n", getMaYeuCau(), getTenYeuCau());
        System.out.printf("| %-10s |\n", getNoiDung());

        // Hiển thị danh sách Minh chứng
        System.out.print("Danh sách Minh chứng \n");
        int index = 1;
        if(dsMinhChung.size()==0){
            System.out.println("Không có danh sách minh chứng ");
        }
        else{
            for (MinhChung minhChung : dsMinhChung) {
                System.out.printf("%d. %-10s - %-20s - %-15s - %-20s\n",
                        index++, minhChung.getMaMinhChung(),
                        minhChung.getTenMinhChung(),
                        CauHinh.f.format(minhChung.getNgayBanHanh()), minhChung.getNoiBanHanh());
            }
        }

    }

    //Kiem Tra Minh Chung da duoc them
    public boolean isCheckMinhChungAdd(MinhChung... minhChungs) {
        return this.dsMinhChung.contains(minhChungs);
    }

    // ham them Minh Chung
    public void addMinhChung(MinhChung... minhChungs) {
        if (!isCheckMinhChungAdd(minhChungs)) {
            this.dsMinhChung.addAll(Arrays.asList(minhChungs));
        } else {
            System.out.println("Minh chứng đã tồn tại trong danh sách");
        }
    }

    public void updateOrAddMinhChung() {
        int choose;
       boolean isFound;
       do {
           isFound = false;
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
                       this.addMinhChung(newMinhChung);
                   } catch (ParseException e) {
                       System.out.println("Ngay ban hanh khong hop le.");
                   }
               }
               break;
               case 2:{
                   boolean found = false;

                   System.out.print("Nhập tên Minh Chứng cần cập nhật: ");
                   String tenMinhChung = CauHinh.sc.nextLine();
                   for (MinhChung mc : dsMinhChung) {
                       if (mc.getTenMinhChung().equals(tenMinhChung)) {
                           System.out.printf("Thông tin hiện tại của Minh Chứng %s\n", tenMinhChung);
                           mc.display();
                           do {
                               System.out.printf("|===============================================|\n");
                               System.out.println("Chọn thông tin cần sửa:");
                               System.out.println("1. Tên minh chứng");
                               System.out.println("2. Nơi ban hành");
                               System.out.println("3. Ngày ban hành");
                               System.out.println("4. Thoat");
                               System.out.printf("|==============================================|\n");
                               System.out.print("-Chon chuc nang  : ");
                               choose = CauHinh.sc.nextInt();
                               CauHinh.sc.nextLine();
                               switch (choose) {
                                   case 1:
                                       System.out.print("Nhập tên minh chứng mới (bỏ qua nếu không muốn sửa): ");
                                       String tenMinhChungMoi = CauHinh.sc.nextLine();
                                       if (!tenMinhChungMoi.isEmpty()) {
                                           mc.setTenMinhChung(tenMinhChungMoi);
                                       }
                                       System.out.print(" Chỉnh sửa thành công ");
                                       break;
                                   case 2:
                                       System.out.print("Nhập nơi ban hành mới (bỏ qua nếu không muốn sửa): ");
                                       String noiBanHanhMoi = CauHinh.sc.nextLine();
                                       if (!noiBanHanhMoi.isEmpty()) {
                                           mc.setNoiBanHanh(noiBanHanhMoi);
                                       }
                                       System.out.print(" Chỉnh sửa thành công ");
                                       break;
                                   case 3:
                                       System.out.print("Nhập ngày ban hành mới (theo định dạng dd/MM/yyyy, bỏ qua nếu không muốn sửa): ");
                                       String ngayBanHanhMoiStr = CauHinh.sc.nextLine();
                                       if (!ngayBanHanhMoiStr.isEmpty()) {
                                           try {
                                               Date ngayBanHanhMoi = CauHinh.f.parse(ngayBanHanhMoiStr);
                                               mc.setNgayBanHanh(ngayBanHanhMoi);
                                           } catch (ParseException e) {
                                               System.out.println("Định dạng ngày không hợp lệ!");
                                           }
                                       }
                                       System.out.print(" Chỉnh sửa thành công ");
                                       break;
                                   case 4:
                                       break;
                                   default:
                                       System.out.println("Lựa chọn không hợp lệ!");
                                       break;
                               }
                           } while (choose != 4);

                           found = true;
                       }
                   }
                   if (!found) {
                       System.out.print("Không tìm thấy tên minh chứng cần cập nhật.");
                   }
               }
               case 3:
                        System.out.print("Nhap ten Minh Chung can xoa : ");
                        String tpmMinhCung = CauHinh.sc.nextLine();
                        this.removeMinhChung(tpmMinhCung);
                        System.out.println("Xoa Minh Chung Thanh cong");

                   break;
               case 4:
                   isFound = true;
                   break;
           }
       }while (!isFound);

    }

    // ham xoa minh chung theo ten
    public void removeMinhChung(String kw) {
        this.dsMinhChung.removeIf(x -> x.getTenMinhChung().contains(kw));
    }


    public TieuChuan getThuocTieuChuan() {
        return thuocTieuChuan;
    }

    public void setThuocTieuChuan(TieuChuan thuocTieuChuan) {
        this.thuocTieuChuan = thuocTieuChuan;
    }

    public ArrayList<MinhChung> getDsMinhChung() {
        return dsMinhChung;
    }

    public void setDsMinhChung(ArrayList<MinhChung> dsMinhChung) {
        this.dsMinhChung = dsMinhChung;
    }

}
