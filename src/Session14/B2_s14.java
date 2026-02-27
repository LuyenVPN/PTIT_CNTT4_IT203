package Session14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2_s14 {
    public static void main(String[] args) {
        Map<String,String> thuoc = new HashMap<>();
        thuoc.put("T01", "Paracetamol");
        thuoc.put("T02", "Ibuprofen");
        thuoc.put("T03", "Amoxicillin");
        thuoc.put("T04", "Aspirin");
        thuoc.put("T05", "Vitamin C");
        Scanner sc = new Scanner(System.in);
        boolean check= false;
        do {
            System.out.printf("Nhập mã thuốc: ");
            String code = sc.nextLine();
            if(thuoc.containsKey(code)){
                System.out.println("Tên thuốc: " + thuoc.get(code));
                check=true;
        }else {
            System.out.println("Thuốc không có trong danh mục BHYT");
        }
        }while (!check);
    }
}