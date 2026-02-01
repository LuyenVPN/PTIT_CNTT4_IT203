package Session6;

public class B4_s6 {

    public static void main(String[] args) {
        // Tạo nhân viên bằng constructor không tham số
        Employee e1 = new Employee();

        // Tạo nhân viên bằng constructor có mã và tên
        Employee e2 = new Employee("E02", "Nguyễn Văn A");

        // Tạo nhân viên bằng constructor đầy đủ
        Employee e3 = new Employee("E03", "Trần Thị B", 15000000);

        // Hiển thị thông tin
        e1.hienThiThongTin();
        e2.hienThiThongTin();
        e3.hienThiThongTin();
    }

    public static class Employee {
        private String maNV;
        private String tenNV;
        private long luong;

        // Constructor không tham số
        public Employee() {
            this.maNV = "";
            this.tenNV = "";
            this.luong = 0;
        }

        // Constructor có mã và tên
        public Employee(String maNV, String tenNV) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = 0;
        }

        // Constructor đầy đủ
        public Employee(String maNV, String tenNV, long luong) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = luong;
        }

        // Phương thức hiển thị thông tin
        public void hienThiThongTin() {
            System.out.println("Mã NV: " + maNV);
            System.out.println("Tên NV: " + tenNV);
            System.out.println("Lương: " + luong);
            System.out.println("---------------------------");
        }
    }
}
