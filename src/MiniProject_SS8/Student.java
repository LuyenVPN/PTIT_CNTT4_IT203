package MiniProject_SS8;

public class Student {

    private String studentId;
    private String name;
    private double score;

    public Student(){}
    public Student(String studentId, String name, int score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score>0 && score<10){
            this.score= score;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setStudentId(String studentId) {
        if (studentId != null && studentId.matches("^SV\\d{3}$")) {
            this.studentId = studentId;
        } else {
            System.out.println("Mã sinh viên không hợp lệ (VD: SV001)");
        }
    }
    public String getRank() {
        if (score >= 8.0) {
            return "Gioi";
        } else if (score >= 6.5) {
            return "Kha";
        } else {
            return "Trung Binh";
        }
    }

    public String toString(){
        return "MSSV: " + studentId + "| Ho Ten: " + name + "| Diem: " + score + "| Xep Loai: " + getRank();
    };
}
