package Session4;

public class B6_s4 {
    public static void main(String[] args) {

        String review = "Cuốn sách này rất xấu và nội dung khá tục. Phần sau thì hơi bậy khiến người đọc cảm thấy ngu khi đọc tiếp.";

        String[] blacklist = {"xấu", "tục", "bậy", "ngu"};

        // lọc từ nhạy cảm
        for (String word : blacklist) {
            String stars = "*".repeat(word.length());
            review = review.replaceAll("(?i)" + word, stars);
        }

        // cắt nếu dài hơn 200 ký tự
        if (review.length() > 200) {
            String temp = review.substring(0, 200);

            while (temp.charAt(temp.length() - 1) != ' ') {
                temp = temp.substring(0, temp.length() - 1);
            }

            review = temp.trim() + "...";
        }

        System.out.println(review);
    }
}
