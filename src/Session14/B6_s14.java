package Session14;

import java.util.*;

class Patient {
    String name;
    int age;
    String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return name + " (" + age + " tuổi)";
    }
}

public class B6_s14 {
    public static void main(String[] args) {

        // Input List
        List<Patient> patients = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 45, "Nội tiết"),
                new Patient("Mai", 28, "Tim mạch")
        );

        // Map<String, List<Patient>>
        Map<String, List<Patient>> tenkhoa = new HashMap<>();

        // ===== Gom nhóm =====
        for (Patient p : patients) {

            if (!tenkhoa.containsKey(p.department)) {
                tenkhoa.put(p.department, new ArrayList<>());
            }

            tenkhoa.get(p.department).add(p);
        }

        // ===== In cấu trúc Map =====
        for (Map.Entry<String, List<Patient>> entry : tenkhoa.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + " -> " + entry.getValue());
        }

        // ===== Tìm khoa đông nhất =====
        String khoa = null;
        int sum = 0;

        for (Map.Entry<String, List<Patient>> xuly : tenkhoa.entrySet()) {
            if (xuly.getValue().size() > sum) {
                sum = xuly.getValue().size();
                khoa = xuly.getKey();
            }
        }

        System.out.println("\nKhoa " + khoa + " đang đông nhất (" + sum + " bệnh nhân)");
    }
}