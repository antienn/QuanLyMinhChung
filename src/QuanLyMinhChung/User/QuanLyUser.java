package QuanLyMinhChung.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyUser {
    private final ArrayList<User> danhSachUser = new ArrayList<>();

    public void addUser(User... dsUser) {
        this.danhSachUser.addAll(Arrays.asList(dsUser));
    }

    public String checkRole(String name, String pass) {
        for (User u : danhSachUser) {
            if (u.isUser(name, pass)) {
                return u.getClass().getSimpleName();
            }
        }
        return null;
    }

    public void display() {
        danhSachUser.forEach(User::display);
    }

    public User findUserByName(String tmpname) {
        for (User u : danhSachUser) {
            if (u.getName().equals(tmpname)) {
                return u;
            }
        }
        return null;
    }

    public List<TruongPhong> dsTruongPhong() {
        List<TruongPhong> ds = new ArrayList<>();
        for (User u : danhSachUser) {
            if (u instanceof TruongPhong) {
                ds.add((TruongPhong) u);
            }
        }
        return ds;
    }

    public List<GiangVien> dsGiangVien() {
        List<GiangVien> ds = new ArrayList<>();
        for (User u : danhSachUser) {
            if (u instanceof GiangVien) {
                ds.add((GiangVien) u);
            }
        }
        return ds;
    }

}
