package MiniProject_SS8;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Student[] students;
    static int n = 0;

    public static void main(String[] args) {
    String choice;
    do{
        System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
        System.out.println("1. Nhập danh sách sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm kiếm sinh viên theo học lực");
        System.out.println("4. Sắp xếp theo học lực giảm dần");
        System.out.println("5. Thoát");
        System.out.println("==================================");
        System.out.print("Chọn chức năng: ");
        choice = sc.nextLine().trim();
        switch (choice){
            case "1":
                inputStudents();
                break;
            case "2":
                showStudents();
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                System.out.println("Thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }while(!choice.equals("5"));
    }
    static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        n = Integer.parseInt(sc.nextLine());
        students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sinh viên thứ " + (i + 1) + " ---");
            Student s = new Student();
            while (true) {
                System.out.print("Nhập mã SV (VD: SV001): ");
                String id = sc.nextLine().trim();

                if (!id.matches("^SV\\d{3}$")) {
                    System.out.println("Sai định dạng!");
                    continue;
                }

                if (isDuplicateId(id, i)) {
                    System.out.println("Mã sinh viên đã tồn tại!");
                    continue;
                }

                s.setStudentId(id);
                break;
            }

            while (true) {
                System.out.print("Nhập họ tên: ");
                String name = sc.nextLine();
                if (name.trim().isEmpty()) {
                    System.out.println("Tên không được rỗng!");
                } else {
                    s.setName(name);
                    break;
                }
            }

            while (true) {
                System.out.print("Nhập điểm TB: ");
                double score = Double.parseDouble(sc.nextLine());
                if (score < 0 || score > 10) {
                    System.out.println(" Điểm phải từ 0 - 10");
                } else {
                    s.setScore(score);
                    break;
                }
            }

            students[i] = s;
        }
    }

    static boolean isDuplicateId(String id, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (students[i] != null &&
                    students[i].getStudentId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    static void showStudents() {
        if (students == null || n == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.println("\n========== DANH SÁCH SINH VIÊN ==========");
        System.out.printf("%-8s | %-20s | %-6s | %-10s%n", "MSSV", "HỌ TÊN", "ĐIỂM", "XẾP LOẠI");
        for (Student s : students) {
            System.out.printf("%-8s | %-20s | %-6.2f | %-10s%n",
                    s.getStudentId(),
                    s.getName(),
                    s.getScore(),
                    s.getRank());
        }
    }
}
