package Session1;
import java.util.Scanner;

public class B2_S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhập số ngày trả trễ (n): ");
        int n = sc.nextInt();

        System.out.print("Nhập số lượng sách mượn (m): ");
        int m = sc.nextInt();

        // Tính tiền phạt cơ bản
        int total = n * m * 5000;

        // Kiểm tra điều kiện đặc biệt
        if (n > 7 && m >= 3) {
            total = (int)(total * 1.2);
        }

        // Kiểm tra yêu cầu khóa thẻ
        boolean needBlockCard = total > 50000;

        // Xuất kết quả
        System.out.println("Tổng tiền phạt: " + total + " VND");
        System.out.println("Yêu cầu khóa thẻ: " + needBlockCard);

        sc.close();
    }
}
