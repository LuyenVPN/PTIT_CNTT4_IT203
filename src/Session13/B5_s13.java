package Session13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + fullName +
                " | Age: " + age +
                " | Diagnosis: " + diagnosis;
    }
}

public class B5_s13 {

    private static List<Patient> patientList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PATIENT MANAGEMENT =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> updateDiagnosis();
                case 3 -> dischargePatient();
                case 4 -> sortPatients();
                case 5 -> displayPatients();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }

    // 1. Thêm bệnh nhân (ID không trùng)
    private static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        if (findById(id) != null) {
            System.out.println("ID đã tồn tại!");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Thêm bệnh nhân thành công.");
    }

    // 2. Cập nhật chẩn đoán
    private static void updateDiagnosis() {
        System.out.print("Nhập ID cần cập nhật: ");
        String id = sc.nextLine();

        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        System.out.print("Nhập chẩn đoán mới: ");
        String newDiagnosis = sc.nextLine();
        p.setDiagnosis(newDiagnosis);

        System.out.println("Cập nhật thành công.");
    }

    // 3. Xuất viện
    private static void dischargePatient() {
        System.out.print("Nhập ID cần xuất viện: ");
        String id = sc.nextLine();

        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        patientList.remove(p);
        System.out.println("Xuất viện thành công.");
    }

    // 4. Sắp xếp theo tuổi giảm dần, nếu bằng thì theo tên A-Z
    private static void sortPatients() {

        patientList.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                // Tuổi giảm dần
                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                // Nếu tuổi bằng -> tên tăng dần
                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("Đã sắp xếp danh sách.");
    }

    // 5. Hiển thị
    private static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Patient p : patientList) {
            System.out.println(p);
        }
    }

    // Tìm theo ID
    private static Patient findById(String id) {
        for (Patient p : patientList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}