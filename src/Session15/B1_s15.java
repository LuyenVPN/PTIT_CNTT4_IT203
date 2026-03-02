package Session15;
import java.util.Stack;

public class B1_s15 {
    public static class EditAction {

        private String description;
        private String time;

        public EditAction(String description, String time) {
            this.description = description;
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public String getTime() {
            return time;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "EditAction{" +
                    "description='" + description + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    public static class MedicalRecordHistory {

        private Stack<EditAction> history;

        public MedicalRecordHistory() {
            history = new Stack<>();
        }

        // push
        public void addEdit(EditAction action) {
            history.push(action);
            System.out.println("Đã thêm chỉnh sửa: " + action);
        }

        // pop
        public EditAction undoEdit() {
            if (history.isEmpty()) {
                System.out.println("Không có chỉnh sửa nào để undo.");
                return null;
            }
            EditAction removed = history.pop();
            System.out.println("Đã undo chỉnh sửa: " + removed);
            return removed;
        }

        // peek
        public EditAction getLatestEdit() {
            if (history.isEmpty()) {
                System.out.println("Stack đang rỗng.");
                return null;
            }
            return history.peek();
        }

        public boolean isEmpty() {
            return history.isEmpty();
        }

        public void displayHistory() {
            if (history.isEmpty()) {
                System.out.println("Không có lịch sử chỉnh sửa.");
                return;
            }

            System.out.println("===== Lịch sử chỉnh sửa (từ cũ đến mới) =====");
            for (EditAction action : history) {
                System.out.println(action);
            }
        }
    }

    public static void main(String[] args) {

        MedicalRecordHistory history = new MedicalRecordHistory();

        history.addEdit(new EditAction("Cập nhật chẩn đoán", "09:00"));
        history.addEdit(new EditAction("Thêm kết quả xét nghiệm", "09:15"));
        history.addEdit(new EditAction("Chỉnh sửa đơn thuốc", "09:30"));

        System.out.println("\nChỉnh sửa gần nhất:");
        System.out.println(history.getLatestEdit());

        System.out.println("\nUndo một lần:");
        history.undoEdit();

        System.out.println("\nStack sau khi undo:");
        history.displayHistory();
    }
}
