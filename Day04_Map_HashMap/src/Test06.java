import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 09:52
 */
public class Test06 {
    public static void main(String[] args) {
        Map<Integer, String> map =new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(integer+map.get(integer));
        }
        map.put(5,"李晓红");
        map.remove(1);
        map.replace(2,"周林");
        System.out.println(map);
    }
}