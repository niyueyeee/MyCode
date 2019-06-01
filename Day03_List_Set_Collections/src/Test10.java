package Day03;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 09:08
 */
public class Test10 {
    public static void main(String[] args) {
        String[] strs = new String[]{"12345", "67891", "12347809933",
                "98765432102", "67891", "12347809933", "67891"};
        LinkedList<String> lin = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            lin.add(strs[i]);
        }
//        System.out.println(lin.size());
//        System.out.println(lin.get(0));
//        System.out.println(lin.remove(0));
        remov(lin);
//        System.out.println(lin.size());
        for (String s : lin) {
            System.out.println(s);
        }
        Iterator<String> iterator = lin.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }


    private static LinkedList<String> remov(LinkedList<String> lin) {
        for (int i = 0; i < lin.size(); i++) {
//            System.out.println(lin.get(i));
            for (int j = 0; j < lin.size(); j++) {
                if (lin.get(i).equals(lin.get(j))) {
                    lin.remove(j);
                }
            }
        }
        return lin;
    }
}
