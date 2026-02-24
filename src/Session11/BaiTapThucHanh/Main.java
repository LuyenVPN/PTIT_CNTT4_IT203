package Session11.BaiTapThucHanh;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];
        drinks[0] = new Coffee("001", "Cà phê sữa", 15000, true);
        drinks[1] = new FruitJuice("002", "Trà xanh", 12000, 10);
        System.out.println("===Hóa đơn cà phê===\n");

        for (Drink drink : drinks) {
            if (drink != null) {
                drink.displayInfo();
                NumberFormat nf = NumberFormat.getNumberInstance();
                if (drink instanceof IMixable) {
                    ((IMixable) drink).mix();
                }
                System.out.println("Thành tiền: " + nf.format(drink.calculatePrice()) + " VND");

                System.out.println();
            }
        }
    }
}
