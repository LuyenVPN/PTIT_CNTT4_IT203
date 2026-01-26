package Session2;

import java.util.Scanner;

public class B1_s2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập tuổi của bạn: ");
        int age = sc.nextInt();
        System.out.print("Nhập số sách đang mượn: ");
        int book = sc.nextInt();

        if (age >= 18 && book < 3) {
            System.out.println("Cho phép mượn sách");
        } else {
            if (age < 18) {
                System.out.println("Bạn chưa đủ tuổi");
            }
            if (book >= 3) {
                System.out.println("Bạn đã mượn quá số lượng cho phép");
            }
        }

        sc.close();
    }
}
