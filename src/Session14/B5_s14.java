package Session14;
import java.util.*;

public class B5_s14 {
    public static void main(String[] args) {

        Comparator<PatientB5> xuly = (p1, p2) -> {

            if (p1.severity != p2.severity) {
                return Integer.compare(p1.severity, p2.severity);
            }

            // Nếu severity bằng nhau → so arrivalTime
            return Integer.compare(p1.arrivalTime, p2.arrivalTime);
        };

        TreeSet<PatientB5> list = new TreeSet<>(xuly);

        // Thêm bệnh nhân
        list.add(new PatientB5("Bệnh nhân A", 3, 800));
        list.add(new PatientB5("Bệnh nhân B", 1, 815));
        list.add(new PatientB5("Bệnh nhân C", 1, 805));

        // In thứ tự xử lý
        System.out.println("Thứ tự xử lý:");
        for (PatientB5 p : list) {
            System.out.println(p);
        }
    }

    public static class PatientB5 {
        String name;
        int severity; // Mức độ nghiêm trọng
        int arrivalTime; // Thời gian đến

        public PatientB5(String name, int severity, int arrivalTime) {
            this.name = name;
            this.severity = severity;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public String toString() {
            return name + " (Mức " + severity +
                    ", đến lúc " + arrivalTime + ")";
        }
    }
}
