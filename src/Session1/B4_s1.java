package Session1;
import java.util.Scanner;

public class B4_s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập giá sách (USD)
        System.out.print("Nhập giá sách (USD): ");
        double priceUSD = sc.nextDouble();

        // Nhập tỷ giá
        System.out.print("Nhập tỷ giá USD sang VND: ");
        float exchangeRate = sc.nextFloat();

        // Tính tổng tiền VNĐ
        double totalVND = priceUSD * exchangeRate;

        // Ép kiểu sang long để lấy số tiền chẵn
        long roundedVND = (long) totalVND;

        // In kết quả
        System.out.println("Giá sách sau quy đổi (VNĐ): " + roundedVND);

        sc.close();
    }
}
