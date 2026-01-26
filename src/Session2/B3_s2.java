package Session2;

import java.util.Scanner;

public class B3_s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach tra muon: ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap so ngay tre cua cuon thu " + i + ": ");
            int ngayTre = sc.nextInt();
            total += ngayTre * 5000;
        }

        System.out.println("===> Tong tien phat: " + total + " VND");
    }
}
