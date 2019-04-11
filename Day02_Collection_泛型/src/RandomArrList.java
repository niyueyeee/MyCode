import java.util.ArrayList;
import java.util.Random;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 02:11
 */
public class RandomArrList {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        ArrayList<Object> obj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(100)+1);
            arr[i] = r.nextInt(100) + 1;
            System.out.print(arr[i] + " ");
            if (arr[i] >= 10) {
                obj.add(arr[i]);
            }
        }
        System.out.println();
        for (Object o : obj) {
            System.out.print(o + " ");

        }
    }
}
