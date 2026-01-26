package Session2;

public class B2_s2 {
    public static void main(String[] args) {
// 2. Mô tả
// Hệ thống cần chỉ dẫn vị trí tầng dựa trên mã thể loại sách (A, B, C, D)

//  

// Yêu cầu:

// Nhập một ký tự code
// Sử dụng switch(code) để phân nhánh:
// 'A': "Tầng 1: Sách Văn học"
// 'B': "Tầng 2: Sách Khoa học"
// 'C': "Tầng 3: Sách Ngoại ngữ"
// 'D': "Tầng 4: Sách Tin học"
// Sử dụng default để xử lý trường hợp nhập sai mã
        char code = 'B';

        switch (code) {
            case 'A':
                System.out.println("Tầng 1: Sách Văn học");
                break;
            case 'B':
                System.out.println("Tầng 2: Sách Khoa học");
                break;
            case 'C':
                System.out.println("Tầng 3: Sách Ngoại ngữ");
                break;
            case 'D':
                System.out.println("Tầng 4: Sách Tin học");
                break;
            default:
                System.out.println("Mã thể loại sách không hợp lệ");
                break;
        }
    }
}
