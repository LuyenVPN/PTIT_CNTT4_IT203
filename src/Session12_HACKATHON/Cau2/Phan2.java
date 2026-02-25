package Session12_HACKATHON.Cau2;

import java.util.Scanner;

public class Phan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập n: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i + 1);
            arr[i] = sc.nextInt();
        }
        System.out.println("Kết quả:");
        boolean check = false;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    check = true;
                    System.out.println(arr[i]);
                }
            }
        }
        if (check == false) {
            System.out.println("Không có số lặp lại");
        }
    }
}
