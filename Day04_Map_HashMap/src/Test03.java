import java.util.HashMap;
import java.util.Set;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 09:03
 */
public class Test03 {
    public static void main(String[] args) {
        HashMap<Object, Object> ham = new HashMap<>();
        ham.put("11","22");
        ham.put("111","222");
        Set<Object> obj = ham.keySet();
//        for (Object o : obj) {
//            Object o1 = ham.get(o);
//            System.out.println(o1);
//        }
        System.out.println(ham.get("11"));
        System.out.println(ham.remove("11"));
    }
}
