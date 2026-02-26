package Session13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Medicine {
    private String drugId;
    private String drugName;
    private double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}

public class B6_s13 {

    private static List<Medicine> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MENU KÊ ĐƠN THUỐC =====");
            System.out.println("1. Thêm thuốc vào đơn");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá dưới 50.000");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addMedicine();
                case 2 -> updateQuantity();
                case 3 -> removeMedicine();
                case 4 -> printInvoice();
                case 5 -> findCheapMedicine();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }

    // Tìm thuốc theo mã
    private static Medicine findById(String id) {
        for (Medicine m : cart) {
            if (m.getDrugId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }

    // 1. Thêm thuốc (cộng dồn số lượng nếu trùng mã)
    private static void addMedicine() {

        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        Medicine existing = findById(id);

        if (existing != null) {
            System.out.print("Nhập số lượng thêm: ");
            int qty = Integer.parseInt(sc.nextLine());
            existing.setQuantity(existing.getQuantity() + qty);
            System.out.println("Đã cộng dồn số lượng.");
            return;
        }

        System.out.print("Nhập tên thuốc: ");
        String name = sc.nextLine();

        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, quantity));
        System.out.println("Thêm thuốc thành công.");
    }

    // 2. Điều chỉnh số lượng
    private static void updateQuantity() {

        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }

        System.out.print("Nhập số lượng mới: ");
        int newQty = Integer.parseInt(sc.nextLine());

        if (newQty == 0) {
            cart.remove(m);
            System.out.println("Đã xóa thuốc khỏi đơn.");
        } else {
            m.setQuantity(newQty);
            System.out.println("Đã cập nhật số lượng.");
        }
    }

    // 3. Xóa thuốc
    private static void removeMedicine() {

        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }

        cart.remove(m);
        System.out.println("Xóa thành công.");
    }

    // 4. In hóa đơn
    private static void printInvoice() {

        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống.");
            return;
        }

        double total = 0;

        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s\n",
                "Mã", "Tên thuốc", "Giá", "SL", "Thành tiền");

        for (Medicine m : cart) {
            System.out.printf("%-10s %-20s %-10.0f %-10d %-15.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    m.getTotalPrice());

            total += m.getTotalPrice();
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TỔNG TIỀN: %.0f VNĐ\n", total);

        // Clear giỏ hàng sau khi in
        cart.clear();
        System.out.println("Đã hoàn tất đơn và làm mới giỏ hàng.");
    }

    // 5. Tìm thuốc giá < 50.000
    private static void findCheapMedicine() {

        boolean found = false;

        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugName() + " - " + m.getUnitPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có thuốc nào dưới 50.000 VNĐ.");
        }
    }
}
