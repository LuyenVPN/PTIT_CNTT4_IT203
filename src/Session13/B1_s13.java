package Session13;
import java.util.ArrayList;
import java.util.Iterator;

public class B1_s13 {
    
        public static void main(String[] args) {

            ArrayList<Double> tt = new ArrayList<>();
            tt.add(36.5);
            tt.add(40.2);
            tt.add(37.0);
            tt.add(12.5);
            tt.add(39.8);
            tt.add(99.9);
            tt.add(36.8);

            System.out.println("Danh sách ban đầu: " + tt);
            Iterator<Double> bd = tt.iterator();
            while (bd.hasNext()) {
                Double temp = bd.next();

                if (temp < 34.0 || temp > 42.0) {
                    bd.remove();
                }
            }

            System.out.println("Danh sách sau khi lọc: " + tt);

            double sum = 0;
            for (Double temp : tt) {
                sum += temp;
            }

            double average = sum / tt.size();
            System.out.printf("Nhiệt độ trung bình: %.2f\n", average);
        }
}
