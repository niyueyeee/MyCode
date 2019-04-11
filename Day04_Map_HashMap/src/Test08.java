import java.util.ArrayList;
import java.util.HashMap;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 10:01
 */
public class Test08 {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("abc");
        str.add("bcd");
        统计(str);
    }

    private static void 统计(ArrayList<String> str) {
        HashMap<Character, Integer> ham = new HashMap<>();
        for (String s : str) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (ham.containsKey(chars[i])) {
                    Integer integer = ham.get(chars[i]);
                    ham.put(chars[i], ++integer);
                } else {
                    ham.put(chars[i], 1);
                }
            }
        }
        System.out.println(ham);
    }
}