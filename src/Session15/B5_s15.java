package Session15;
import java.util.*;
public class B5_s15 {
    public static class TreatmentStep {

        private String description;
        private String time;

        public TreatmentStep(String description, String time) {
            this.description = description;
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return description + " - " + time;
        }
    }
    public static class Patient {

        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age + " tuổi";
        }
    }
    public static class EmergencyCase {

        private Patient patient;
        private Stack<TreatmentStep> steps;

        public EmergencyCase(Patient patient) {
            this.patient = patient;
            this.steps = new Stack<>();
        }

        public void addStep(TreatmentStep step) {
            steps.push(step);
            System.out.println("Thêm bước xử lý: " + step);
        }

        public TreatmentStep undoStep() {
            if (steps.isEmpty()) {
                System.out.println("Không có bước nào để undo.");
                return null;
            }

            TreatmentStep removed = steps.pop();
            System.out.println("Undo bước: " + removed);
            return removed;
        }

        public void displaySteps() {
            if (steps.isEmpty()) {
                System.out.println("Chưa có bước xử lý.");
                return;
            }

            System.out.println("=== Các bước xử lý cho " + patient + " ===");
            for (TreatmentStep step : steps) {
                System.out.println(step);
            }
        }

        public Patient getPatient() {
            return patient;
        }
    }
    public static class EmergencyCaseQueue {

        private Queue<EmergencyCase> cases;

        public EmergencyCaseQueue() {
            cases = new LinkedList<>();
        }

        public void addCase(EmergencyCase c) {
            cases.offer(c);
            System.out.println("Tiếp nhận ca: " + c.getPatient());
        }

        public EmergencyCase getNextCase() {
            if (cases.isEmpty()) {
                System.out.println("Không còn ca cấp cứu.");
                return null;
            }

            EmergencyCase next = cases.poll();
            System.out.println("Đang xử lý: " + next.getPatient());
            return next;
        }
    }
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        // Thêm bệnh nhân vào Queue (FIFO)
        EmergencyCase case1 = new EmergencyCase(
                new Patient("BN01", "Nguyễn Văn A", 30));

        EmergencyCase case2 = new EmergencyCase(
                new Patient("BN02", "Trần Thị B", 45));

        queue.addCase(case1);
        queue.addCase(case2);

        System.out.println();

        // Lấy bệnh nhân đầu tiên
        EmergencyCase current = queue.getNextCase();

        // Thêm các bước xử lý (Stack - LIFO)
        current.addStep(new TreatmentStep("Tiếp nhận", "09:00"));
        current.addStep(new TreatmentStep("Chẩn đoán", "09:10"));
        current.addStep(new TreatmentStep("Điều trị", "09:30"));

        System.out.println();
        current.displaySteps();

        System.out.println();
        current.undoStep(); // Undo bước gần nhất

        System.out.println();
        current.displaySteps();
    }

}
