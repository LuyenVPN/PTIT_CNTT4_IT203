package Session4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B5_s4 {
    public static void main(String[] args) {
        String[] logs = {
                "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345",
                "2024-05-21 | User: TranVanB | Action: RETURN | BookID: BK54321",
                "2024-05-22 | User: NguyenVanA | Action: BORROW | BookID: BK99999"
        };

        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}) \\| User: ([A-Za-z]+) \\| Action: (BORROW|RETURN) \\| BookID: ([A-Z]{2}\\d+)");

        int borrowCount = 0;
        int returnCount = 0;

        for (int i = 0; i < logs.length; i++) {
            Matcher matcher = pattern.matcher(logs[i]);
            if (matcher.find()) {
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookID = matcher.group(4);

                System.out.println("Ngày: " + date);
                System.out.println("Người dùng: " + user);
                System.out.println("Hành động: " + action);
                System.out.println("Mã sách: " + bookID);
                System.out.println();

                if (action.equals("BORROW")) borrowCount++;
                else if (action.equals("RETURN")) returnCount++;
            }
        }

        System.out.println("Tổng BORROW: " + borrowCount);
        System.out.println("Tổng RETURN: " + returnCount);
    }
}
