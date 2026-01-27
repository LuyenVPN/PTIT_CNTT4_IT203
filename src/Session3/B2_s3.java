package Session3;
import java.util.Scanner;

public class B2_s3 {
        public static int searchBooks(String[] arr, String search) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equalsIgnoreCase(search)) {
                    return i;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String[] books = {
                    "ABC",
                    "CDB",
                    "AEC",
                    "CSDL",
                    "MMT"
            };

            System.out.print("Nhập tên sách cần tìm: ");
            String search = sc.nextLine();

            int index = searchBooks(books, search);

            if (index != -1) {
                System.out.println("Tìm thấy tại vị trí " + index);
            } else {
                System.out.println("Sách không tồn tại");
            }
        }
}
