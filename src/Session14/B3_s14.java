package Session14;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class B3_s14 {
    public static void main(String[] args) {
        Set<String> A = new HashSet<>();
        A.add("Aspirin");
        A.add("Caffeine");
        A.add("Paracetamol");
        Set<String> B = new HashSet<>();
        B.add("Aspirin");
        B.add("Penicillin");
        Set<String> C = new HashSet<>(A);
        C.retainAll(B);
        Set<String> D = new HashSet<>(A);
        D.removeAll(B);
        System.out.printf("Thành phần thuốc: " + A);
        System.out.printf("\nThành phần dị ứng: " + B);
        System.out.printf("\n-------------------------------\n");
        if (!C.isEmpty()) {
            System.out.println("Cảnh báo dị ứng: " + C);
        } else {
            System.out.println("Không có thành phần gây dị ứng.");
        }
        System.out.println("Thành phần an toàn: " + D);
    }
}
