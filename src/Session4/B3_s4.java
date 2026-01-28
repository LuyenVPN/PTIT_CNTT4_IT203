package Session4;

public class B3_s4 {
    public static void main(String[] args) {
        String[] transactions = {
                "BK001-20/01",
                "BK005-21/01",
                "BK099-22/01"
        };

        long startString = System.currentTimeMillis();
        String reportString = "";
        reportString += "--- BÁO CÁO MƯỢN SÁCH ---\n";
        reportString += "Ngày tạo: 24/01/2026\n";
        for (int i = 0; i < transactions.length; i++) {
            reportString += "Giao dịch: " + transactions[i] + "\n";
        }
        long endString = System.currentTimeMillis();

        long startBuilder = System.currentTimeMillis();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        reportBuilder.append("Ngày tạo: 24/01/2026\n");
        for (int i = 0; i < transactions.length; i++) {
            reportBuilder.append("Giao dịch: ").append(transactions[i]).append("\n");
        }
        long endBuilder = System.currentTimeMillis();

        System.out.println(reportBuilder.toString());
        System.out.println("Số thời gian thực thi đối với StringBuilder: " + (endBuilder - startBuilder));
        System.out.println("Số thời gian thực thi đối với String: " + (endString - startString));
    }
}
