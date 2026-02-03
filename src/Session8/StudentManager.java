package Session8;

import java.util.Scanner;

public class StudentManager {
    private Student[] students;
    private int count;

    public StudentManager(int size) {
        students = new Student[size];
        count = 0;
    }

    public int timTheoMa(String ma) {
        for (int i = 0; i < count; i++) {
            if (students[i].getMaSV().equalsIgnoreCase(ma))
                return i;
        }
        return -1;
    }

    public void them(Student s) {
        if (count == students.length) {
            System.out.println("Danh sách đầy!");
            return;
        }
        if (timTheoMa(s.getMaSV()) != -1) {
            System.out.println("Mã sinh viên bị trùng!");
            return;
        }
        students[count++] = s;
        System.out.println("Thêm sinh viên thành công.");
    }

    public void hienThi() {
        if (count == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.printf("%-10s | %-20s | %-5s | %-8s | %-6s | %-10s\n",
                "Mã SV", "Họ tên", "Tuổi", "GT", "ĐTB", "Xếp loại");
        for (int i = 0; i < count; i++) {
            students[i].hienThi();
        }
    }

    public void timKiem(String key) {
        if (count == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        boolean found = false;

        // 1. thử tìm theo mã sinh viên (chính xác)
        int idx = timTheoMa(key);
        if (idx != -1) {
            System.out.println("Kết quả tìm theo mã sinh viên:");
            System.out.printf("%-10s | %-20s | %-5s | %-8s | %-6s | %-10s\n",
                    "Mã SV", "Họ tên", "Tuổi", "GT", "ĐTB", "Xếp loại");
            students[idx].hienThi();
            return;
        }

        System.out.println("Kết quả tìm theo tên:");
        System.out.printf("%-10s | %-20s | %-5s | %-8s | %-6s | %-10s\n",
                "Mã SV", "Họ tên", "Tuổi", "GT", "ĐTB", "Xếp loại");

        for (int i = 0; i < count; i++) {
            if (students[i].getHoTen().toLowerCase()
                    .contains(key.toLowerCase())) {
                students[i].hienThi();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }


    public void capNhat(String ma, String ten, int tuoi, String gt,
                        double toan, double ly, double hoa) {
        if (count == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        int i = timTheoMa(ma);
        if (i == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }
        students[i].setHoTen(ten);
        students[i].setTuoi(tuoi);
        students[i].setGioiTinh(gt);
        students[i].setDiem(toan, ly, hoa);
        System.out.println("Cập nhật thành công.");
    }

    public void xoa(String ma) {
        if (count == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        int i = timTheoMa(ma);
        if (i == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn chắc chắn muốn xóa? (y/n): ");
        String chon = sc.nextLine();

        if (!chon.equalsIgnoreCase("y")) {
            System.out.println("Đã hủy xóa.");
            return;
        }

        for (int j = i; j < count - 1; j++) {
            students[j] = students[j + 1];
        }
        students[--count] = null;
        System.out.println("Đã xóa sinh viên.");
    }

    public void thongKe() {
        if (count == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        double tong = 0;

        Student max = students[0];
        Student min = students[0];

        for (int i = 0; i < count; i++) {
            tong += students[i].getDiemTB();

            if (students[i].getXepLoai().equals("Giỏi")) gioi++;
            else if (students[i].getXepLoai().equals("Khá")) kha++;
            else if (students[i].getXepLoai().equals("Trung bình")) tb++;
            else yeu++;

            if (students[i].getDiemTB() > max.getDiemTB()) max = students[i];
            if (students[i].getDiemTB() < min.getDiemTB()) min = students[i];
        }

        System.out.println("=== THỐNG KÊ ===");
        System.out.println("Giỏi: " + gioi);
        System.out.println("Khá: " + kha);
        System.out.println("Trung bình: " + tb);
        System.out.println("Yếu: " + yeu);
        System.out.printf("Điểm TB chung: %.2f\n", tong / count);

        System.out.print("SV điểm cao nhất:  ");
        max.hienThi();
        System.out.print("SV điểm thấp nhất: ");
        min.hienThi();
    }
    public void sapXepTheoDiemTB() {
        if (count <= 1) {
            System.out.println("Danh sách không đủ để sắp xếp.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getDiemTB() < students[j + 1].getDiemTB()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Đã sắp xếp theo điểm trung bình giảm dần.");
    }
    public void sapXepTheoTenAZ() {
        if (count <= 1) {
            System.out.println("Danh sách không đủ để sắp xếp.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < count; j++) {
                if (students[j].getHoTen()
                        .compareToIgnoreCase(students[minIndex].getHoTen()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Student temp = students[i];
                students[i] = students[minIndex];
                students[minIndex] = temp;
            }
        }

        System.out.println("Đã sắp xếp theo tên A-Z.");
    }
    public boolean isEmpty() {
        return count == 0;
    }

}