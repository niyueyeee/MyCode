import java.util.ArrayList;
import java.util.Collections;

/**
 * @authro niyueyeee
 * @create 2019-01-17 上午 11:20
 */
public class Stream02 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        Collections.addAll(arr,
                "陈玄风", "梅超风", "陆乘风", "曲灵风", "武眠风", "冯默风", "罗玉风");
        arr.stream().limit(2).forEach(s -> System.out.println(s));
        arr.stream().skip(arr.size() - 2).forEach(s -> System.out.println(s));
    }
}
