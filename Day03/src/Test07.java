package Day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 08:48
 */
public class Test07 {
    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("张三");
        li.add("李四");
        li.add("王五");
        li.add("赵六");

        for (int i = 0; i < li.size(); i++) {
            if (li.get(i) == "李四") {
                li.set(i, "22");
            }
        }
        System.out.println(li);
    }
}
