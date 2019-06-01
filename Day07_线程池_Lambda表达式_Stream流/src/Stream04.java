import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @authro niyueyeee
 * @create 2019-01-17 上午 11:35
 */
public class Stream04 {
    public static void main(String[] args) {
        List<String> list = Stream.concat(Stream.of("郭靖", "杨康"), Stream.of("黄蓉", "穆念慈")).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
