package Session12_HACKATHON.Cau2;

import java.util.Scanner;

public class Phan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập n: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i + 1);
            arr[i] = sc.nextInt();
        }
        int sum = 1;
        int []check = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
//                    check[i]= arr[i];
                    sum++;
                }
//                sum = 0;
//                if (arr[j]==check[i]) {
//                    j++;
//                    break;
//                }
            }
            System.out.println("Số "+arr[i]+" xuất hiện"+sum);

        }
    }
}
