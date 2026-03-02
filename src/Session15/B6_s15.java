package Session15;
import java.util.*;

public class B6_s15 {
    public static class Patient {
        private String id;
        private String name;
        private int age;
        private String gender;

        public Patient(String id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age + " - " + gender;
        }
    }

    public static class PatientWaitingQueue {

        private Queue<Patient> waitingQueue;
        private int totalPatients;

        public PatientWaitingQueue() {
            waitingQueue = new LinkedList<>();
            totalPatients = 0;
        }

        public void addPatient(Patient p) {
            waitingQueue.offer(p);
            totalPatients++;
            System.out.println("Đã thêm bệnh nhân: " + p);
        }

        public Patient callPatient() {
            if (waitingQueue.isEmpty()) {
                System.out.println("Không có bệnh nhân đang chờ.");
                return null;
            }
            totalPatients--;
            return waitingQueue.poll();
        }

        public void displayQueue() {
            System.out.println("===== Danh sách chờ khám =====");
            for (Patient p : waitingQueue) {
                System.out.println(p);
            }
        }
    }

    public static class EditAction {
        private String description;
        private String editedBy;
        private String editTime;

        public EditAction(String description, String editedBy, String editTime) {
            this.description = description;
            this.editedBy = editedBy;
            this.editTime = editTime;
        }

        @Override
        public String toString() {
            return description + " | " + editedBy + " | " + editTime;
        }
    }

    public static class MedicalRecordHistory {

        private Stack<EditAction> editStack;
        private String recordId;

        public MedicalRecordHistory(String recordId) {
            this.recordId = recordId;
            editStack = new Stack<>();
        }

        public void addEdit(EditAction action) {
            editStack.push(action);
        }

        public EditAction undoEdit() {
            if (editStack.isEmpty()) {
                System.out.println("Không có chỉnh sửa để undo.");
                return null;
            }
            return editStack.pop();
        }

        public void displayHistory() {
            System.out.println("===== Lịch sử bệnh án " + recordId + " =====");
            for (EditAction e : editStack) {
                System.out.println(e);
            }
        }
    }

    public static class Ticket {
        private int ticketNumber;
        private String issuedTime;

        public Ticket(int ticketNumber, String issuedTime) {
            this.ticketNumber = ticketNumber;
            this.issuedTime = issuedTime;
        }

        @Override
        public String toString() {
            return "Số: " + ticketNumber + " | " + issuedTime;
        }
    }

    public static class TicketSystem {

        private Queue<Ticket> ticketQueue;
        private int currentNumber;

        public TicketSystem() {
            ticketQueue = new LinkedList<>();
            currentNumber = 1;
        }

        public Ticket issueTicket(String time) {
            Ticket t = new Ticket(currentNumber++, time);
            ticketQueue.offer(t);
            return t;
        }

        public Ticket callNext() {
            return ticketQueue.poll();
        }
    }

    public static class InputAction {
        private String fieldName;
        private String oldValue;
        private String newValue;
        private String actionTime;

        public InputAction(String fieldName, String oldValue,
                           String newValue, String actionTime) {
            this.fieldName = fieldName;
            this.oldValue = oldValue;
            this.newValue = newValue;
            this.actionTime = actionTime;
        }

        @Override
        public String toString() {
            return fieldName + ": " + oldValue + " -> " + newValue;
        }
    }

    public static class UndoManager {

        private Stack<InputAction> undoStack;
        private int maxUndoSteps;

        public UndoManager(int maxUndoSteps) {
            this.maxUndoSteps = maxUndoSteps;
            undoStack = new Stack<>();
        }

        public void recordAction(InputAction action) {
            if (undoStack.size() >= maxUndoSteps) {
                undoStack.remove(0);
            }
            undoStack.push(action);
        }

        public InputAction undo() {
            if (undoStack.isEmpty()) return null;
            return undoStack.pop();
        }
    }


    public static void main(String[] args) {

        // Test Queue bệnh nhân
        PatientWaitingQueue queue = new PatientWaitingQueue();
        queue.addPatient(new Patient("BN01", "An", 30, "Nam"));
        queue.addPatient(new Patient("BN02", "Bình", 25, "Nữ"));
        queue.displayQueue();

        System.out.println("\nGọi khám: " + queue.callPatient());

        // Test Stack chỉnh sửa
        MedicalRecordHistory history = new MedicalRecordHistory("REC001");
        history.addEdit(new EditAction("Thêm chẩn đoán", "Dr.A", "09:00"));
        history.addEdit(new EditAction("Cập nhật thuốc", "Dr.A", "09:10"));
        System.out.println("\nUndo chỉnh sửa: " + history.undoEdit());

        // Test Ticket System
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.issueTicket("09:00");
        ticketSystem.issueTicket("09:05");
        System.out.println("\nGọi số: " + ticketSystem.callNext());

        // Test Undo nhập liệu
        UndoManager undoManager = new UndoManager(5);
        undoManager.recordAction(
                new InputAction("Name", "An", "Anh", "10:00"));
        System.out.println("\nUndo nhập liệu: " + undoManager.undo());
    }
}
