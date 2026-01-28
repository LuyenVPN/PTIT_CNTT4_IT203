package Session4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B4_s4 {
    public static void main(String[] args) {
        String cardID = "TV202312345";

        Pattern fullPattern = Pattern.compile("^[A-Z]{2}[0-9]{4}[0-9]{5}$");
        Matcher fullMatcher = fullPattern.matcher(cardID);

        if (fullMatcher.matches()) {
            System.out.println("Mã thẻ hợp lệ!");
        } else {
            if (!cardID.matches("^[A-Z]{2}.*")) {
                System.out.println("Thiếu tiền tố 2 chữ cái viết hoa");
            } else if (!cardID.matches("^[A-Z]{2}[0-9]{4}.*")) {
                System.out.println("Năm không hợp lệ");
            } else if (!cardID.matches("^[A-Z]{2}[0-9]{4}[0-9]{5}$")) {
                System.out.println("Phần số cuối không hợp lệ");
            } else {
                System.out.println("Mã thẻ không hợp lệ");
            }
        }
    }
}
