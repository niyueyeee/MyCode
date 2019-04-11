import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 09:39
 */
public class Test05 {
    public static void main(String[] args) {
        HashMap<String, String> ham = new HashMap<>();
        ham.put("a", "22");
        ham.put("b", "22222");
        Set<String> characters = ham.keySet();
        for (String character : characters) {
            System.out.println(ham.get(character));
        }
        Set<Map.Entry<String, String>> entries = ham.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+entry.getValue());

        }
    }
}
