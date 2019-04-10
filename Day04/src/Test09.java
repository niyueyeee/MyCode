import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 10:01
 */
public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> m = getIntegerStringMap();
        年份(sc, m);
        国家(sc, m);
    }

    private static void 国家(Scanner sc, Map<Integer, String> m) {
        System.out.println("请输入一个国家:");
        String s = sc.nextLine();
        if (!m.containsValue(s)) {
            System.out.println("没有获得过世界杯");
        } else {
            for (Integer integer : m.keySet()) {
                if (m.get(integer).equals(s)) {
                    System.out.println(integer);
                }
            }
        }
    }

    private static void 年份(Scanner sc, Map<Integer, String> m) {
        System.out.println("请输入一个年份:");
        String s = sc.nextLine();
        if (!m.containsKey(s)) {
            System.out.println("没有举办世界杯");
        }
    }

    private static Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> m = new HashMap<>();

        m.put(1930, "乌拉圭");
        m.put(1934, "意大利");
        m.put(1938, "意大利");
        m.put(1950, "乌拉圭");
        m.put(1954, "西德");
        m.put(1958, "巴西");
        m.put(1962, "巴西");
        m.put(1966, "英格兰");
        m.put(1970, "巴西");
        m.put(1974, "西德");
        m.put(1978, "阿根廷");
        m.put(1982, "意大利");
        m.put(1986, "阿根廷");
        m.put(1990, "西德");
        m.put(1994, "巴西");
        m.put(1998, "法国");
        m.put(2002, "巴西");
        m.put(2006, "意大利");
        m.put(2010, "西班牙");
        m.put(2014, "德国");
        return m;
    }
}
