package Day02;

import java.util.ArrayList;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 07:37
 */
public class DemoCollection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("word");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);

        }
    }
}
