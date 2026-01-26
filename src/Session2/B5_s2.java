package Session2;

import java.util.Scanner;

public class B5_s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int diem = 100;

        System.out.println("--- HE THONG DANH GIA DOC GIA ---");
        System.out.println("(Nhap so ngay tre. Nhap 999 de ket thuc)");

        while (true) {
            System.out.print("So ngay tre cua lan nay: ");
            int ngayTre = sc.nextInt();

            if (ngayTre == 999) {
                break;
            }

            if (ngayTre <= 0) {
                diem += 5;
                System.out.println("-> Tra dung han: +5 diem.");
            } else {
                int tru = ngayTre * 2;
                diem -= tru;
                System.out.println("-> Tra tre " + ngayTre + " ngay: -" + tru + " diem.");
            }

            System.out.println();
        }

        System.out.println("Tong diem uy tin: " + diem);

        if (diem > 120) {
            System.out.println("Xep loai: DOC GIA THAN THIET");
        } else if (diem >= 80) {
            System.out.println("Xep loai: DOC GIA TIEU CHUAN");
        } else {
            System.out.println("Xep loai: DOC GIA CAN LUU Y");
        }
    }
}
