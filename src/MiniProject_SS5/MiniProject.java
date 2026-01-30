package MiniProject_SS5;

import java.util.Scanner;

public class MiniProject {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;

        do {
            showMenu();
            System.out.print("Nhập lựa chọn của bạn (0-5): ");

            String input = sc.nextLine().trim();

            // kiểm tra có phải số không
            if (!input.matches("[0-5]")) {
                System.out.println("Vui lòng chỉ nhập số từ 0 đến 5!");
                continue;
            }

            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
            }

        } while (choice != 0);
    }

    // ===== MENU =====
    static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. [FR1] Two Sum - Tìm cặp số có tổng bằng K");
        System.out.println("2. [FR2] Move Zeroes - Dồn số 0 về cuối");
        System.out.println("3. [FR3] Valid Palindrome - Chuỗi đối xứng (Regex)");
        System.out.println("4. [FR4] Reverse Words - Đảo ngược từ trong câu");
        System.out.println("5. [FR5] Happy Number - Số hạnh phúc");
        System.out.println("0. Thoát");
    }

    // ===== FR1: TWO SUM =====
    static void twoSum(){
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Nhập target: ");
        int target = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tìm thấy tại vị trí: " + i + " và " + j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("Không tìm thấy cặp số phù hợp.");
        }
    }

    // ===== FR2: MOVE ZEROES =====
    static void moveZeroes() {
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < n) {
            arr[index] = 0;
            index++;
        }

        System.out.print("Mảng sau khi dồn số 0: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ===== FR3: VALID PALINDROME =====
    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        s = s.replaceAll("[^a-zA-Z]", "");
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        boolean isPalindrome = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Kết quả: " + isPalindrome);
    }

    // ===== FR4: REVERSE WORDS =====
    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        s = s.trim();
        if (s.length() == 0) {
            System.out.println("Chuỗi rỗng!");
            return;
        }

        String[] words = s.split("\\s+");

        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) {
                result += " ";
            }
        }

        System.out.println("Chuỗi sau khi đảo: " + result);
    }

    // ===== FR5: HAPPY NUMBER =====
    static void happyNumber() {
        System.out.print("Nhập số n: ");
        int n = sc.nextInt();

        int slow = n;
        int fast = n;

        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            System.out.println(n + " là số hạnh phúc.");
        } else {
            System.out.println(n + " không phải là số hạnh phúc.");
        }
    }

    static int sumSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
