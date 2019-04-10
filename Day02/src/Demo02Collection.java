package Day02;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 09:34
 */
public class Demo02Collection {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));
    }

    private static int listTest(Collection<String> list, String a) {
        int i = 0;
        for (String s : list) {
            if (a.equals(s)){
                i++;
            }
        }
        return i;
    }
}
