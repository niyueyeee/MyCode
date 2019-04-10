import java.util.HashMap;

/**
 * @authro niyueyeee
 * @create 2019-01-11 上午 10:00
 */
public class Test07 {
    public static void main(String[] args) {
        String[] key = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] val = {"哈尔滨","杭州","南昌","广州省","福州"};
        HashMap<Object, Object> ham = new HashMap<>();

        for (int i = 0; i < key.length; i++) {
            ham.put(key[i],val[i]);
        }
        System.out.println(ham);
    }
}
