package Session15;
import  java.util.*;

public class B2_s15 {
    public static class Patient {

        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age + " tuổi";
        }
    }

    public static class PatientQueue {

        private Queue<Patient> queue;

        public PatientQueue() {
            queue = new LinkedList<>();
        }

        // enqueue
        public void addPatient(Patient p) {
            queue.offer(p);
            System.out.println("Đã thêm bệnh nhân: " + p);
            displayQueue();
        }

        // dequeue
        public Patient callNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("Không còn bệnh nhân nào đang chờ.");
                return null;
            }

            Patient next = queue.poll();
            System.out.println("Đang khám: " + next);
            displayQueue();
            return next;
        }

        // peek
        public Patient peekNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("Hàng đợi rỗng.");
                return null;
            }
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void displayQueue() {
            if (queue.isEmpty()) {
                System.out.println("Danh sách chờ trống.\n");
                return;
            }

            System.out.println("===== Danh sách bệnh nhân đang chờ =====");
            for (Patient p : queue) {
                System.out.println(p);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        PatientQueue patientQueue = new PatientQueue();

        patientQueue.addPatient(new Patient("BN01", "Nguyễn Văn A", 30));
        patientQueue.addPatient(new Patient("BN02", "Trần Thị B", 25));
        patientQueue.addPatient(new Patient("BN03", "Lê Văn C", 40));

        System.out.println("Bệnh nhân tiếp theo: "
                + patientQueue.peekNextPatient());
        System.out.println();

        patientQueue.callNextPatient();
        patientQueue.callNextPatient();
    }
}
