package Session16;

import java.text.NumberFormat;
import java.util.*;
import Session16.Model.*;
import Session16.Manager.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static PetManager petManager = new PetManager();
    static CustomerManager customerManager = new CustomerManager();
    static SpaManager spaManager = new SpaManager();
    static LogManager logManager = new LogManager();

    public static void main(String[] args) {

        while (true) {
            hienThiMenu();
            int choice = nhapSoHopLe(0, 6);

            switch (choice) {
                case 1:
                    themThuCung();
                    break;

                case 2:
                    hienThiThuCung();
                    break;

                case 3:
                    xoaThuCung();
                    break;

                case 4:
                    themKhachHang();
                    break;

                case 5:
                    dichVuSpa();
                    break;

                case 6:
                    logManager.undo();
                    break;

                case 0:
                    thongBao("Thoát chương trình. Tạm biệt!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }

    // ================= MENU =================

    static void hienThiMenu() {
        System.out.println("\n========= PET KINGDOM =========");
        System.out.println("1. Thêm thú cưng");
        System.out.println("2. Hiển thị danh sách thú cưng");
        System.out.println("3. Xóa thú cưng");
        System.out.println("4. Thêm khách hàng");
        System.out.println("5. Dịch vụ Spa");
        System.out.println("6. Hoàn tác (Undo)");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    // ================= THÚ CƯNG =================

    static void themThuCung() {
        inTieuDe("THÊM THÚ CƯNG");

        String id = nhapChuoi("Nhập ID: ");
        if (petManager.findById(id) != null) {
            thongBao("ID đã tồn tại.");
            return;
        }

        String name = nhapChuoi("Tên: ");
        String species = nhapChuoi("Loài: ");
        int age = nhapSoDuong("Tuổi: ");
        double price = nhapSoDuongDouble("Giá: ");

        Pet pet = new Pet(id, name, species, age, price);
        petManager.add(pet);
        logManager.log("Thêm thú cưng " + name);

        thongBao("Thêm thành công.");
    }

    static void hienThiThuCung() {
        inTieuDe("DANH SÁCH THÚ CƯNG");

        if (petManager.getAll().isEmpty()) {
            thongBao("Chưa có thú cưng nào.");
            return;
        }

        System.out.printf("%-10s %-15s %-15s %-5s %-10s%n",
                "ID", "Tên", "Loài", "Tuổi", "Giá");
        System.out.println("------------------------------------------------------------");
        NumberFormat nf = NumberFormat.getNumberInstance();
        for (Pet p : petManager.getAll()) {
            System.out.printf("%-10s %-15s %-15s %-5d %-10s%n",
                    p.getId(),
                    p.getName(),
                    p.getSpecies(),
                    p.getAge(),
                    nf.format(p.getPrice()));
        }
    }

    static void xoaThuCung() {
        inTieuDe("XÓA THÚ CƯNG");

        String id = nhapChuoi("Nhập ID cần xóa: ");

        if (petManager.deleteById(id)) {
            logManager.log("Xóa thú cưng ID " + id);
            thongBao("Xóa thành công.");
        } else {
            thongBao("Không tìm thấy thú cưng.");
        }
    }

    // ================= KHÁCH HÀNG =================

    static void themKhachHang() {
        inTieuDe("THÊM KHÁCH HÀNG");

        String id = nhapChuoi("Nhập ID: ");
        String name = nhapChuoi("Tên: ");
        String phone = nhapChuoi("Số điện thoại: ");

        if (customerManager.add(new Customer(id, name, phone))) {
            logManager.log("Thêm khách hàng " + name);
            thongBao("Thêm thành công.");
        } else {
            thongBao("ID đã tồn tại.");
        }
    }

    // ================= SPA =================

    static void dichVuSpa() {
        inTieuDe("DỊCH VỤ SPA");

        String id = nhapChuoi("Nhập ID thú cưng: ");
        Pet pet = petManager.findById(id);

        if (pet == null) {
            thongBao("Không tìm thấy thú cưng.");
            return;
        }

        String type = nhapChuoi("Loại dịch vụ: ");

        spaManager.addToQueue(new ServiceRecord(pet, type));
        logManager.log("Thú cưng " + pet.getName() + " vào Spa");

        ServiceRecord serving = spaManager.serveNext();
        System.out.println("\n Đang phục vụ: " + serving);
    }

    // ================= VALIDATE =================

    static String nhapChuoi(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Không được để trống!");
        }
    }

    static int nhapSoHopLe(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    System.out.print("Nhập số từ " + min + " đến " + max + ": ");
                } else return choice;
            } catch (Exception e) {
                System.out.print(" Vui lòng nhập số hợp lệ: ");
            }
        }
    }

    static int nhapSoDuong(String message) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= 0) return number;
                System.out.println("Phải >= 0");
            } catch (Exception e) {
                System.out.println("Nhập số hợp lệ!");
            }
        }
    }

    static double nhapSoDuongDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double number = Double.parseDouble(sc.nextLine());
                if (number >= 0) return number;
                System.out.println("Phải >= 0");
            } catch (Exception e) {
                System.out.println("Nhập số hợp lệ!");
            }
        }
    }

    // ================= UI SUPPORT =================

    static void inTieuDe(String title) {
        System.out.println("\n==============================");
        System.out.println("   " + title);
        System.out.println("==============================");
    }

    static void thongBao(String msg) {
        System.out.println("\n" + msg);
    }
}