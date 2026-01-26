package Session2;

import java.util.Scanner;

public class B4_s2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int id;
        do {
            System.out.print("Nhạp id sách mới (phải >0): ");
            id = sc.nextInt();
            if (id<=0){
                System.out.println("Id sách không hợp lệ, vui lòng nhập lại.");
            }
        }while (id<=0);
        System.out.println("Xac nhan: Ma sach " + id + " da duoc ghi nhan.");
    }
}
