package Session12_HACKATHON.Cau1;

import java.util.Scanner;

public class Phan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập chuỗi ký tự hỗn hợp: ");
        String chuoi = sc.nextLine();
        if(chuoi.length()==0){
            System.out.println("Lỗi: không nhập nội dung");
            return;
        }
        int sum=0;
        String n ="";
        for (int i=0;i<chuoi.length();i++){
            char ch = chuoi.charAt(i);
            if(ch>='0'&&ch<='9'){
                n+=ch;
            }else {
                if (n.length()>0) {
                    sum+=Integer.parseInt(n);
                    n="";
                }
            }
        }
        if(n.length()>0){
            sum+=Integer.parseInt(n);
        }
        System.out.println(sum);
    }
}
