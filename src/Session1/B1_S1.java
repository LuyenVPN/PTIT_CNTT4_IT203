package Session1;
import java.util.Scanner;

public class B1_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhập mã sách: ");
        String bookID = scanner.nextLine();

        System.out.print("Nhập tên sách: ");
        String bookName = scanner.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear = scanner.nextInt();

        System.out.print("Nhập giá sách: ");
        double price = scanner.nextDouble();

        System.out.print("Sách còn trong kho? (true/false): ");
        boolean isAvailable = scanner.nextBoolean();

        // Tính tuổi thọ sách
        int bookAge = 2026 - publishYear;

        // Xử lý dữ liệu
        String bookNameUpper = bookName.toUpperCase();
        String status = isAvailable ? "Còn sách" : "Đã mượn";

        // Xuất thông tin
        System.out.println("\n===== PHIẾU THÔNG TIN SÁCH =====");
        System.out.println("Mã sách      : " + bookID);
        System.out.println("Tên sách     : " + bookNameUpper+ "  |  "+ "Tuổi thọ sách: " + bookAge + " năm");
        System.out.printf("Giá tiền     : %.2f%n", price);
        System.out.println("Tình trạng   : " + status);
    }
}
