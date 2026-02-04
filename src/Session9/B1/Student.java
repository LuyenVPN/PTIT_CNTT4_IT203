package Session9.B1;

public class Student extends Person{
    private String studentId;
    private double gpa;

    public Student() {
        super();
    }

    public Student(String studentId,String fullname, int age, double gpa) {
        super(fullname, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Điểm GPA: " + gpa);
    }
};
