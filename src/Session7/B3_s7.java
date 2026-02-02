package Session7;

public class B3_s7 {
    public static class ScoreUtils {
        public static boolean checkPass(double score) {
            return score >= 5.0;
        }

        public static double calculateAverage(double[] scores) {
            double sum = 0;

            for (double score : scores) {
                sum += score;
            }

            return sum / scores.length;
        }
    }
    public static void main(String[] args) {

        double[] scores = {6.5, 8.0, 4.5};

        System.out.println("Danh sách điểm: 6.5, 8.0, 4.5");
        System.out.println();
        System.out.println(">> Kết quả xử lý:");

        double average = ScoreUtils.calculateAverage(scores);
        System.out.printf("- Điểm trung bình cả lớp: %.2f\n", average);

        for (double score : scores) {
            if (ScoreUtils.checkPass(score)) {
                System.out.println("- Điểm " + score + ": Đạt");
            } else {
                System.out.println("- Điểm " + score + ": Trượt");
            }
        }
    }


}
