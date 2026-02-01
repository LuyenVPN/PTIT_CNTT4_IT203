package Session6;

public class B3_s6 {
    public static class Product {
    private int maSP;
    private String tenSP;
    private double giaBan;

    public Product(int maSP, String tenSP, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        setGiaBan(giaBan);
    }

    public void setGiaBan(double giaBan) {
        if (giaBan > 0) {
            this.giaBan = giaBan;
        } else {
            System.out.println("Giá bán phải lớn hơn 0");
        }
    }

    public void displayInfo() {
        System.out.println("Mã SP: " + maSP);
        System.out.println("Tên SP: " + tenSP);
        System.out.println("Giá bán: " + giaBan);
    }

    }
    public static void main(String[] args) {
        Product sp1 = new Product(1, "Iphone 19", 5000000);
        sp1.displayInfo();
        sp1.setGiaBan(-88888888);
        sp1.setGiaBan(1);
        sp1.displayInfo();
    }
}