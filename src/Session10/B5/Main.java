package Session10.B5;

public class Main {
    public static void main(String[] args) {

        Employee staff = new OfficeStaff("Nguyen Van A", 8000000);
        Employee manager = new Manager("Tran Van B", 12000000, 3000000);

        System.out.printf("%-15s | %-15s | %-15s%n", "Ten", "Luong co ban", "Luong thuc nhan");
        System.out.println("-------------------------------------------");

        staff.printInfo();
        manager.printInfo();
    }
}
