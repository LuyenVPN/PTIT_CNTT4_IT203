package Session7;

public class B2_s7 {
    public static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // ===== PRIMITIVE TYPE =====
        int a = 10;
        int b = a;   // sao chép giá trị

        b = 20;

        System.out.println("Primitive:");
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20

        System.out.println("--------------------");

        // ===== REFERENCE TYPE =====
        Student s1 = new Student("Nguyễn Văn A");
        Student s2 = s1; // sao chép địa chỉ

        s2.name = "Trần Thị B";

        System.out.println("Reference:");
        System.out.println("s1.name = " + s1.name); // Trần Thị B
        System.out.println("s2.name = " + s2.name); // Trần Thị B
    }
}
