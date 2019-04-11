import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 09:09
 */
public class Test04 {
    public static void main(String[] args) {
        HashMap<Object, Object> ham = new HashMap<>();
        ham.put("11", "22");
        ham.put("111", "22222");
        ham.put("111", "22222");
        Collection<Object> values = ham.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Iterator<Object> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
