import java.util.HashMap;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-10 下午 07:56
 */
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(":");
        String str = sc.nextLine();
        HashMap<Character, Integer> ham = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            Integer integer = ham.containsKey(c) ? ham.put(c,ham.get(c)) : ham.put(c, 1);
            System.out.println(integer);

        }
//        System.out.println(ham);
    }
}
