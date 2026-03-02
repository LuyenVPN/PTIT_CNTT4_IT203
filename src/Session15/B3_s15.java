package Session15;
import java.util.*;
public class B3_s15 {
    public static class danhsachkham {

        private Stack<String> stack;

        public danhsachkham() {
            stack = new Stack<>();
        }

        public boolean checkProcess(String[] actions) {

            reset();

            System.out.println("===== Bắt đầu kiểm tra quy trình =====");

            for (int i = 0; i < actions.length; i++) {

                String action = actions[i];

                if (action.equalsIgnoreCase("PUSH")) {

                    stack.push("Medication");
                    System.out.println("Bước " + (i + 1) + ": PUSH → Phát thuốc");

                } else if (action.equalsIgnoreCase("POP")) {

                    if (stack.isEmpty()) {
                        System.out.println("Lỗi tại bước " + (i + 1)
                                + ": POP khi chưa có thuốc đang phát.");
                        return false;
                    }

                    stack.pop();
                    System.out.println("Bước " + (i + 1) + ": POP → Hoàn tất phát thuốc");

                } else {

                    System.out.println("Hành động không hợp lệ tại bước "
                            + (i + 1) + ": " + action);
                    return false;
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("Quy trình sai: Vẫn còn "
                        + stack.size() + " thuốc chưa hoàn tất.");
                return false;
            }

            System.out.println("Quy trình hợp lệ. Ca trực hoàn tất.");
            return true;
        }

        public void reset() {
            stack.clear();
        }
    }
    public static void main(String[] args) {

        danhsachkham checker = new danhsachkham();

        // Test hợp lệ
        String[] process1 = {"PUSH", "PUSH", "POP", "POP"};

        // Test lỗi POP khi rỗng
        String[] process2 = {"POP", "PUSH"};

        // Test còn dư PUSH
        String[] process3 = {"PUSH", "PUSH", "POP"};

        System.out.println("\nTest 1:");
        checker.checkProcess(process1);

        System.out.println("\nTest 2:");
        checker.checkProcess(process2);

        System.out.println("\nTest 3:");
        checker.checkProcess(process3);
    }
}
