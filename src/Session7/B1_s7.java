package Session7;

public class B1_s7 {
    public static class  Student {

        private String studentId;
        private String name;

        private static int totalStudent = 0;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            totalStudent++;
        }

        public void displayInfo() {
            System.out.println("Mã SV: " + studentId);
            System.out.println("Tên SV: " + name);
        }

        public static void displayTotalStudent() {
            System.out.println("Tổng số sinh viên đã tạo: " + totalStudent);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("SV01", "Nguyễn Văn A");
        Student s2 = new Student("SV02", "Trần Thị B");
        Student s3 = new Student("SV03", "Lê Văn C");

        s1.displayInfo();
        System.out.println();

        s2.displayInfo();
        System.out.println();

        s3.displayInfo();
        System.out.println();

        Student.displayTotalStudent();
    }
}
