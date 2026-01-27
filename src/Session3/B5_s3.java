package Session3;

import java.util.Scanner;

public class B5_s3 {
    public static int deleteBook(int[] arr, int n, int bookId) {
        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Không tìm thấy mã sách cần xóa");
            return n;
        }

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        System.out.println("Đã xóa mã sách: " + bookId);
        return n - 1;
    }

    // in mảng đến n phần tử
    public static void displayBooks(int[] arr, int n) {
        if (n == 0) {
            System.out.println("Danh sách sách rỗng");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // mảng ISBN ban đầu
        int[] books = {101, 202, 303, 404, 505};
        int n = 5;

        while (n > 0) {
            System.out.print("Danh sách hiện tại: ");
            displayBooks(books, n);

            System.out.print("Nhập mã sách cần xóa: ");
            int bookId = sc.nextInt();

            n = deleteBook(books, n, bookId);

            if (n == 0) {
                System.out.println("Không còn sách nào trong danh sách");
                break;
            }

            System.out.print("Bạn có muốn tiếp tục xóa không? (y/n): ");
            char choice = sc.next().charAt(0);
            if (choice != 'y' && choice != 'Y') {
                break;
            }
        }
    }
}
