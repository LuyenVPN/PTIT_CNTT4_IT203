package Session3;

public class B3_s3 {
    public static void maxBook(String[] names, int[] quantities) {
        int max = quantities[0];

        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.println("Sách có số lượng lớn nhất:");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i] + ": " + quantities[i]);
            }
        }
    }

    public static void minBook(String[] names, int[] quantities) {
        int min = quantities[0];

        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.println("Sách có số lượng nhỏ nhất:");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i] + ": " + quantities[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {
                "Java Programming",
                "Data Structure",
                "Algorithm",
                "Database System",
                "Computer Network"
        };

        int[] quantities = {10, 5, 10, 3, 3};

        maxBook(names, quantities);
        minBook(names, quantities);
    }
}
