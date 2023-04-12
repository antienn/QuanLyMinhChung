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

    public void sapXepMinhChungNgayBanHanh() {
        this.dsMinhChung.sort(Comparator.comparing(MinhChung::getNgayBanHanh));
    }

    public void displayTieuChi() {
        // Hiển thị Tiêu chí
        System.out.printf("| %-10s | %-5s |\n", getMaYeuCau(), getTenYeuCau());
        System.out.println("|--------------------|");
        System.out.printf("| %-10s |\n", getNoiDung());
        System.out.println("|----------------------|");

        // Hiển thị danh sách Minh chứng
        System.out.println("Danh sách Minh chứng:");
        int index = 1;
        for (MinhChung minhChung : dsMinhChung) {
            System.out.printf("%d. %-10s - %-20s - %-15s - %-20s\n", index++, minhChung.getMaMinhChung(), minhChung.getTenMinhChung(), CauHinh.f.format(minhChung.getNgayBanHanh()), minhChung.getNoiBanHanh());
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
        System.out.println("Bạn muốn thêm Minh Chứng mới hay cập nhật Minh Chứng có sẵn?");
        System.out.println("1. Thêm mới");
        System.out.println("2. Cập nhật Minh Chứng có sẵn");
        System.out.print("- Chọn chức năng: ");
        choose = CauHinh.sc.nextInt();
        CauHinh.sc.nextLine(); // Đọc ký tự '\n' sau khi nhập số integer
        if (choose == 1) {
           // Them Minh Chung Cho Tieu Chi

        } else if (choose == 2) {
            boolean found = false;

            System.out.print("Nhập tên Minh Chứng cần cập nhật: ");
            String tenMinhChung = CauHinh.sc.nextLine();
            for (MinhChung mc : dsMinhChung) {
                if (mc.getTenMinhChung().equals(tenMinhChung)) {
                    System.out.printf("Thông tin hiện tại của Minh Chứng %s\n", tenMinhChung);
                    mc.display();
                    System.out.printf("=================================================\n");
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
