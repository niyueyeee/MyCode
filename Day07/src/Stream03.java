import java.util.stream.Stream;

/**
 * @authro niyueyeee
 * @create 2019-01-17 上午 11:29
 */
public class Stream03 {
    public static void main(String[] args) {
        Stream.of(1,-1,-3,4,-5).map(Math::abs).forEach(System.out::println);
    }
}
