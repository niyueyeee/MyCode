import java.util.stream.Stream;

/**
 * @authro niyueyeee
 * @create 2019-01-15 下午 07:34
 */
public class Test {
    public static void main(String[] args) {
        Stream.concat(Stream.of("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公").filter(s -> s.length() == 3).limit(3), Stream.of("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三").filter(s -> s.startsWith("张")).skip(2)).forEach(s -> System.out.println(s));
    }
}
