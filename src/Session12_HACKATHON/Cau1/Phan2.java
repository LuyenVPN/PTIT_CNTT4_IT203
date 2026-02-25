package Session12_HACKATHON.Cau1;

import java.util.Scanner;

public class Phan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập chuỗi bất kỳ: ");
        String chuoi = sc.nextLine();
        if(chuoi.length()==0){
            System.out.println("Lỗi: không nhập nội dung");
            return;
        }
        int i,j;
        for (i = 0; i < chuoi.length(); i++) {
            for (j = i+1; j < chuoi.length(); j++) {
                if (chuoi.charAt(i) == chuoi.charAt(j)) {
//                    System.out.println("có");
                }
            }
        }
    }
}
