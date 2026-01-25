package Session1;
import java.util.Scanner;

public class B6_s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số thứ tự sách
        System.out.print("Nhập số thứ tự sách (stt): ");
        int stt = sc.nextInt();
        
        // Xác định kệ sách
        int ke = (stt - 1) / 25 + 1;

        // Xác định vị trí trên kệ
        int viTri = (stt - 1) % 25 + 1;

        // Xác định khu vực bằng toán tử điều kiện
        String khuVuc = (ke <= 10) ? "Khu Cận" : "Khu Viễn";

        // In địa chỉ lưu kho hoàn chỉnh
        System.out.println("Kệ số " + ke + " - Vị trí " + viTri + " - Khu vực " + khuVuc);

        sc.close();
    }
}
