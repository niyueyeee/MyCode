import java.util.ArrayList;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 01:02
 */
public class CollectionContains {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("a");
        a1.add("s");
        System.out.println(listTest(a1, "s"));
        System.out.println(isTest(a1));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(13);
        System.out.println(listVal(list,20));
    }

    private static int listVal(ArrayList<Integer> list, int i) {
        return list.indexOf(i);
    }

    private static boolean isTest(ArrayList<String> a1) {
        if (a1.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean listTest(ArrayList<String> a1, String s) {
        if (a1.contains(s)) {
            return true;
        }
        return false;
    }
}
