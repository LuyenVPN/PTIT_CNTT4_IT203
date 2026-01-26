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
            System.out.println("Kết quả: Bạn Đủ điều kiện mượn sách quý hiếm");
        } else {
            if (age < 18) {
                System.out.println("Kết quả: Bạn Không đủ điều kiện");
                System.out.println("Lý do: Bạn phải đủ 18 tuổi trở lên");
            }
            if (book >= 3) {
                System.out.println("Kết quả: Bạn Không đủ điều kiện");
                System.out.println("Lý do: Bạn đã mượn tối đa 3 cuốn sách");
            }
        }

        sc.close();
    }
}
