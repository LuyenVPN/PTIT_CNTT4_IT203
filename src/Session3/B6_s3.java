package Session3;

public class B6_s3 {
    public static void sort(int[] arr) {
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

    public static int[] mergeBooks(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int k = 0;

        // gộp
        for (int i = 0; i < a.length; i++) temp[k++] = a[i];
        for (int i = 0; i < b.length; i++) temp[k++] = b[i];

        // sắp xếp
        sort(temp);

        // bỏ trùng
        int count = 1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != temp[i - 1]) {
                temp[count++] = temp[i];
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayFirst  = {1, 3, 5, 7, 9};
        int[] arraySecond = {3, 4, 5, 8, 9};
        System.out.println("Array First:");
        display(arrayFirst);
        System.out.println("Array Second:");
        display(arraySecond);
        System.out.printf("Kết quả: \t");
        int[] merge = mergeBooks(arrayFirst, arraySecond);
        display(merge);
    }
}
