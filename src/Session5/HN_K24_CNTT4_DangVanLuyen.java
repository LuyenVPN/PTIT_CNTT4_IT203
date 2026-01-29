package Session5;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HN_K24_CNTT4_DangVanLuyen {
    Scanner sc= new Scanner(System.in);
    static int maxStudent = 100;
    static int score=0;
    static String []listStudent = new String[maxStudent];
    static final String mssvValidate = "^B\\d{7}$";
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ MSSV =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới MSSV");
            System.out.println("3. Cập nhật MSSV theo index");
            System.out.println("4. Xóa MSSV");
            System.out.println("5. Tìm kiếm MSSV");
            System.out.println("6. Thoát");
            System.out.println("Nhập Lựa Chọn Của Bạn: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    // Hiển thị danh sách
                    displayListStudent();
                    break;
                case 2:
                    // Thêm mới MSSV
                    addStudent();
                    break;
                case 3:
                    // Cập nhật MSSV theo index
                    updateStudent();
                    break;
                case 4:
                    // Xóa MSSV
                    break;
                case 5:
                    // Tìm kiếm MSSV
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }while (choice != 6);
    }
    static boolean isValidMssv(String mssv) {
        if (!Pattern.matches(mssvValidate,mssv )) {
            System.out.println("Sai định dạng! Ví dụ đúng: B2101234");
            return false;
        }
        return true;
    }
    static public void displayListStudent(){
        if (score ==0){
            System.out.println("Danh sách rỗng.");
        } else {
            System.out.println("Danh sách MSSV:");
            for (int i = 0; i < score; i++) {
                    System.out.println((i + 1) + ". " + listStudent[i]);
            }
        }
    }

    static public void addStudent(){
        if (score==maxStudent){
            System.out.println("Danh sách đã đầy, không thể thêm sinh viên mới.");
        } else {
            String mssv;
            do {
                System.out.print("Nhập MSSV mới: ");
                mssv = new Scanner(System.in).nextLine().trim();
            } while (!isValidMssv(mssv));

            listStudent[score] = mssv;
            score++;
            System.out.println("Đã thêm MSSV: " + mssv  +"thành công.");
        }
    }

    static public void updateStudent(){
        if(score==0){
            System.out.println("Danh sách rỗng, không thể cập nhật.");
        } else {
            displayListStudent();
            System.out.print("Nhập vị trí MSSV cần cập nhật: ");
            int index = new Scanner(System.in).nextInt() - 1;
            if (index < 0 || index >= score) {
                System.out.println("Vị trí không hợp lệ.");
            } else {
                String mssv;
                do {
                    System.out.print("Nhập MSSV mới: ");
                    mssv = new Scanner(System.in).nextLine().trim();
                } while (!isValidMssv(mssv));
                listStudent[index] = mssv;
                System.out.println("Đã cập nhật MSSV tại vị trí " + (index + 1) + " thành công.");
            }
        }
    }

}
