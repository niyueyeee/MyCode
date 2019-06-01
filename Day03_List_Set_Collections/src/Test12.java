package Day03;

import java.util.HashSet;
import java.util.Random;

/**
 * @authro niyueyeee
 * @create 2019-01-10 上午 09:32
 */
public class Test12 {
    public static void main(String[] args) {
//        ArrayList<Object> red = new ArrayList<>();
//        ArrayList<Object> blue = new ArrayList<>();
        HashSet<Integer> has = new HashSet<>();
        Random ran = new Random();
        while (has.size() < 6) {
            has.add(ran.nextInt(33) + 1);
        }
        int blue = (ran.nextInt(16) + 1);
        for (Integer ha : has) {
            System.out.print(ha + " ");
        }
        System.out.println(blue);
    }
}
