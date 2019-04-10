package Day02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 07:53
 */
public class DemoCollection2 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("hello");
        coll.add("word");
        coll.add("java");
        System.out.println(coll.contains("hello"));
        System.out.println(coll.isEmpty());
        System.out.println(coll.size());
        System.out.println(coll.remove("hello"));
        System.out.println(coll);
        Object[] obj = coll.toArray();

        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        for (String s : coll) {
            System.out.println(s);

        }
    }
}
