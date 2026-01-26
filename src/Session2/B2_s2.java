package Session2;

import java.util.Scanner;

public class B2_s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thể loại sách (A, B, C, D): ");
        char code= sc.next().charAt(0);

        switch (code) {
            case 'A':
                System.out.println("Vị Trí: Tầng 1 - Sách Văn học");
                break;
            case 'B':
                System.out.println("Vị Trí: Tầng 2 - Sách Khoa học");
                break;
            case 'C':
                System.out.println("Vị Trí: Tầng 3 - Sách Ngoại ngữ");
                break;
            case 'D':
                System.out.println("Vị Trí: Tầng 4 - Sách Tin học");
                break;
            default:
                System.out.println("Mã thể loại sách không hợp lệ");
                break;
        }
    }
}
