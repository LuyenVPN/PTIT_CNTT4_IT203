package Session2;

import java.util.Scanner;

public class B6_s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int min = 0;
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.print("Nhap so luot muon sach ngay thu " + i + ": ");
            int borrow = sc.nextInt();

            if (borrow == 0) {
                continue;
            }

            if (count == 0) {
                max = borrow;
                min = borrow;
            } else {
                if (borrow > max) {
                    max = borrow;
                }
                if (borrow < min) {
                    min = borrow;
                }
            }

            sum += borrow;
            count++;
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.println("Trung binh luot muon: " + average);
        } else {
            System.out.println("Khong co ngay nao mo cua");
        }
    }
}
