package Session3;

public class B4_s3 {
    public static void sortBooks(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void displayBooks(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] books = {45, 12, 78, 34, 23};

        System.out.print("Mảng trước khi sắp xếp: ");
        displayBooks(books);

        sortBooks(books);

        System.out.print("Mảng sau khi sắp xếp: ");
        displayBooks(books);
    }
}
