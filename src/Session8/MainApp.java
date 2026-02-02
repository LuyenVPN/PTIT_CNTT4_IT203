package Session8;

import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager manager = new StudentManager(100);
        String choice;

        do {
            menu();
            System.out.print("Chọn chức năng: ");
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    them(manager);
                    break;
                case "2":
                    manager.hienThi();
                    break;
                case "3":
//                    manager.timTheoTen(nhapChuoi("Nhập tên cần tìm"));
                    String key = nhapChuoi("Nhập mã SV hoặc tên SV");
                    manager.timKiem(key);
                    break;
                case "4":
                    capNhat(manager);
                    break;
                case "5":
                    manager.xoa(nhapChuoi("Nhập mã SV"));
                    break;
                case "6":
                    System.out.println("Điểm TB & xếp loại được tính tự động.");
                    break;
                case "8":
                    manager.thongKe();
                    break;
                case "9":
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (!choice.equals("9"));
    }

    static void menu() {
        System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Tìm kiếm theo tên");
        System.out.println("4. Cập nhật sinh viên");
        System.out.println("5. Xóa sinh viên");
        System.out.println("6. Tính điểm & xếp loại");
        System.out.println("8. Thống kê");
        System.out.println("9. Thoát");
    }

    /* ===== VALIDATE INPUT ===== */

    static String nhapChuoi(String label) {
        String s;
        while (true) {
            System.out.print(label + ": ");
            s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống!");
        }
    }

    static int nhapTuoi() {
        String input;
        int tuoi;

        while (true) {
            System.out.print("Tuổi (18-30): ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Tuổi không được trống!");
                continue;
            }

            boolean isNumber = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    isNumber = false;
                    break;
                }
            }

            if (!isNumber) {
                System.out.println("Tuổi phải là số!");
                continue;
            }

            tuoi = Integer.parseInt(input);
            if (tuoi < 18 || tuoi > 30) {
                System.out.println("Tuổi phải từ 18 đến 30!");
                continue;
            }

            return tuoi;
        }
    }

    static double nhapDiem(String mon) {
        String input;
        double diem;

        while (true) {
            System.out.print("Điểm " + mon + " (0-10): ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Điểm không được trống!");
                continue;
            }

            boolean isNumber = true;
            int dot = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '.') {
                    dot++;
                    if (dot > 1) {
                        isNumber = false;
                        break;
                    }
                } else if (!Character.isDigit(c)) {
                    isNumber = false;
                    break;
                }
            }

            if (!isNumber || input.equals(".")) {
                System.out.println("Điểm phải là số!");
                continue;
            }

            diem = Double.parseDouble(input);
            if (diem < 0 || diem > 10) {
                System.out.println("Điểm phải từ 0 đến 10!");
                continue;
            }

            return diem;
        }
    }

    static String nhapGioiTinh() {
        String gt;
        while (true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            gt = sc.nextLine().trim();
            if (gt.equalsIgnoreCase("Nam") || gt.equalsIgnoreCase("Nữ"))
                return gt;
            System.out.println("Chỉ nhập Nam hoặc Nữ!");
        }
    }

    static void them(StudentManager m) {
        String ma = nhapChuoi("Mã SV");
        if (m.timTheoMa(ma) != -1) {
            System.out.println("Mã sinh viên đã tồn tại. Không thể thêm!");
            return;
        }

        String ten = nhapChuoi("Họ tên");
        int tuoi = nhapTuoi();
        String gt = nhapGioiTinh();

        double toan = nhapDiem("Toán");
        double ly   = nhapDiem("Lý");
        double hoa  = nhapDiem("Hóa");

        m.them(new Student(ma, ten, tuoi, gt, toan, ly, hoa));
    }


    static void capNhat(StudentManager m) {
        String ma = nhapChuoi("Nhập mã SV cần cập nhật");

        if (m.timTheoMa(ma) == -1) {
            System.out.println("Không tìm thấy sinh viên. Không thể cập nhật!");
            return;
        }

        String ten = nhapChuoi("Tên mới");
        int tuoi = nhapTuoi();
        String gt = nhapGioiTinh();

        double toan = nhapDiem("Toán");
        double ly   = nhapDiem("Lý");
        double hoa  = nhapDiem("Hóa");

        m.capNhat(ma, ten, tuoi, gt, toan, ly, hoa);
    }

}
