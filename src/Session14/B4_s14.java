package Session14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class B4_s14 {
    public static void main(String[] args) {
        List<String> Benh = new ArrayList<String>();
        Benh.add("Cúm A");
        Benh.add("Sốt xuất huyết");
        Benh.add("Cúm A");
        Benh.add("Covid-19");
        Benh.add("Cúm A");
        Benh.add("Sốt xuất huyết");
        Map<String, Integer> BaoCao = new TreeMap<>();
        for (String sum : Benh) {
            if (BaoCao.containsKey(sum)) {
                BaoCao.put(sum, BaoCao.get(sum) + 1);
            } else {
                BaoCao.put(sum, 1);
            }
        }
        System.out.printf("%-20s | %s%n", "Tên bệnh", "Số ca");
        System.out.println("---------------------|------");

        BaoCao.forEach((tenbenh, count) ->
                System.out.printf("%-20s | %d ca%n", tenbenh, count)
        );

    }
}
