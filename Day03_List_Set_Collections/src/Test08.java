package Day03;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 09:01
 */
public class Test08 {
    public static void main(String[] args) {
        LinkedHashSet<String> lin = new LinkedHashSet<>();
        lin.add("王昭君");
        lin.add("西施");
        lin.add("杨玉环");
        lin.add("貂蝉");
        for (String s : lin) {
            System.out.print(s + " ");
        }
        System.out.println();
        Iterator<String> it = lin.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.print(next + " ");
        }
    }
}
