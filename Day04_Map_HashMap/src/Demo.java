import java.util.*;

/**
 * @authro niyueyeee
 * @create 2019-01-10 下午 07:35
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zhangsan", "lisi");
        map.put("wangwu", "zhaoliu");
        Set<String> str = map.keySet();
        //System.out.println(map.get(str));
        Iterator<String> it = str.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String s = map.get(next);
            System.out.println(next + " " + s);
        }
        System.out.println("-------------");
        Collection<String> val = map.values();
        for (String s : val) {
            System.out.println(s);
        }
        System.out.println("-------------");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }
        System.out.println("-------------");
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
