package Session15;
import java.util.*;
public class B4_s15 {
    public static class EmergencyPatient {

        private String id;
        private String name;
        private int priority; // 1: cấp cứu, 2: thường
        private long arrivalOrder; // dùng để đảm bảo FIFO cùng mức độ

        public EmergencyPatient(String id, String name, int priority) {
            this.id = id;
            this.name = name;
            this.priority = priority;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        public long getArrivalOrder() {
            return arrivalOrder;
        }

        public void setArrivalOrder(long arrivalOrder) {
            this.arrivalOrder = arrivalOrder;
        }

        @Override
        public String toString() {
            String level = (priority == 1) ? "CẤP CỨU" : "THƯỜNG";
            return id + " - " + name + " - " + level;
        }
    }

    public static class EmergencyQueue {

        private PriorityQueue<EmergencyPatient> queue;
        private long sequence = 0; // đếm thứ tự đến

        public EmergencyQueue() {

            queue = new PriorityQueue<>(new Comparator<EmergencyPatient>() {
                @Override
                public int compare(EmergencyPatient p1, EmergencyPatient p2) {

                    // Ưu tiên theo mức độ (1 trước 2)
                    if (p1.getPriority() != p2.getPriority()) {
                        return Integer.compare(p1.getPriority(), p2.getPriority());
                    }

                    // Nếu cùng mức độ → FIFO theo arrivalOrder
                    return Long.compare(p1.getArrivalOrder(), p2.getArrivalOrder());
                }
            });
        }

        public void addPatient(EmergencyPatient p) {

            p.setArrivalOrder(sequence++);
            queue.offer(p);

            System.out.println("Đã tiếp nhận: " + p);
            displayQueue();
        }

        public EmergencyPatient callNextPatient() {

            if (queue.isEmpty()) {
                System.out.println("Không còn bệnh nhân.");
                return null;
            }

            EmergencyPatient next = queue.poll();
            System.out.println("Đang khám: " + next);
            displayQueue();
            return next;
        }

        public void displayQueue() {

            if (queue.isEmpty()) {
                System.out.println("Danh sách chờ trống.\n");
                return;
            }

            System.out.println("===== Danh sách chờ (theo thứ tự ưu tiên) =====");

            PriorityQueue<EmergencyPatient> temp =
                    new PriorityQueue<>(queue);

            while (!temp.isEmpty()) {
                System.out.println(temp.poll());
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient(new EmergencyPatient("BN01", "Nguyễn Văn A", 2));
        eq.addPatient(new EmergencyPatient("BN02", "Trần Thị B", 1));
        eq.addPatient(new EmergencyPatient("BN03", "Lê Văn C", 2));
        eq.addPatient(new EmergencyPatient("BN04", "Phạm Văn D", 1));

        eq.callNextPatient();
        eq.callNextPatient();
    }
}
