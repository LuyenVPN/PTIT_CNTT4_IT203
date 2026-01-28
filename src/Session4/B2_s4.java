package Session4;

public class B2_s4 {
    public static void main(String[] args) {
        String description = "Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới";

        if (description.contains("Kệ:")) {
            int start = description.indexOf("Kệ:") + 4;
            int end = description.indexOf(",", start);

            String position;
            if (end != -1) {
                position = description.substring(start, end).trim();
            } else {
                position = description.substring(start).trim();
            }

            System.out.println("Vị trí tìm thấy: " + position);

            String newDescription = description.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println("Mô tả mới: " + newDescription + ".");
        } else {
            System.out.println("Không tìm thấy thông tin kệ sách");
        }
    }
}
