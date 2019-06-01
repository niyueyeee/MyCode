import java.util.stream.Stream;

/**
 * @authro niyueyeee
 * @create 2019-01-17 上午 11:09
 */
public class Stream01 {
    public static void main(String[] args) {
        for (String s : Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏")
                .filter(s -> s.startsWith("郭")).toArray(String[]::new)) {
            System.out.println(s);
        }
    }
}
