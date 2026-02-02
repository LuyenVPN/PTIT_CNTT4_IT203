package Session7;

public class B4_s7 {
    public static class ClassRoom {
        private static double classFund = 0;

        private String studentName;

        public ClassRoom(String studentName) {
            this.studentName = studentName;
        }

        public void payFund(double amount) {
            if (amount > 0) {
                classFund += amount;
                System.out.println(studentName + " đã đóng: " + amount);
            }
        }

        public static void showClassFund() {
            System.out.println("Tổng quỹ lớp hiện tại: " + classFund);
        }
    }
    public static void main(String[] args) {

        ClassRoom s1 = new ClassRoom("Nguyễn Văn A");
        ClassRoom s2 = new ClassRoom("Trần Thị B");
        ClassRoom s3 = new ClassRoom("Lê Văn C");

        s1.payFund(100000);
        s2.payFund(200000);
        s3.payFund(150000);

        System.out.println();
        ClassRoom.showClassFund();
    }
}
