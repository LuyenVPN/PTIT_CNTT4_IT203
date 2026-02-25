package Session12_HACKATHON;

import java.util.Scanner;

public class Cau3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập n:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.printf("a[%d]= ",i);
            arr[i]=sc.nextInt();
        }
        System.out.printf("Nhập m:");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0;i<m;i++){
            System.out.printf("a[%d]= ",i);
            arr2[i]=sc.nextInt();
        }
        boolean check = false;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(arr[i]==arr2[j]){
                   check=true;
                }
            }
        }
        if(check){
            System.out.println("Mảng B là mảng con của mảng A");
        }else {
            System.out.println("Mảng B không là mảng con của mảng A");
        }
    }
}
