package Session3;

import java.util.Scanner;

public class B1_s3 {
    public static int[] addBook(int n) {
        Scanner sc = new Scanner(System.in);
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập mã sách thứ " + (i + 1) + ": ");
            books[i] = sc.nextInt();
        }

        return books;
    }

    public static void display(int[] arr) {
        System.out.print("Danh sách mã sách: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách: ");
        int n = sc.nextInt();

        int[] libraries = addBook(n);
        display(libraries);
    }
}
