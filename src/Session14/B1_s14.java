package Session14;

import java.util.*;

public class B1_s14 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        );
    Set<String> xuly = new LinkedHashSet<>(input);
    Set<String> xuly2 = new HashSet<>(input);
    System.out.println("Danh Sách Gọi Khám: ");
    //Dùng LinkedHashSet để giữ nguyên thứ tự nhập vào
    for (String s : xuly){
        System.out.println(s);
    }
        System.out.printf("-----------------------------\n");
    // Dùng HashSet để loại bỏ hoàn toàn trùng lặp
        for (String s : xuly2){
            System.out.println(s);
        }
    }
}
