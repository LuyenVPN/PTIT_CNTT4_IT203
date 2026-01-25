package Session1;
import java.util.Scanner;

public class B5_s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mã sách 4 chữ số
        System.out.print("Nhập mã sách 4 chữ số: ");
        int number = sc.nextInt();

        // Tách từng chữ số (không dùng String)
        int thousands = number / 1000;
        int hundreds = (number / 100) % 10;
        int dozens = (number / 10) % 10;
        int units = number % 10;

        // Tính tổng 3 chữ số đầu
        int sumOfFirstThreeNumber = thousands + hundreds + dozens;

        // Kiểm tra mã hợp lệ
        boolean isValid = (sumOfFirstThreeNumber % 10) == units;

        // In kết quả
        System.out.println("Mã hợp lệ: " + isValid);

        sc.close();
    }
}
