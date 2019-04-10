import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 03:32
 */
public class Test13 {
    public static <T> T getObj(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        //长度为5的String数组
        String[] obj1 = getObj(() -> new String[5]);

        //包含5个1-20(含1和20)之间随机数的HashSet<Integer>集合
        HashSet<Integer> obj2 = getObj(() -> {
            HashSet<Integer> integers = new HashSet<>();
            Random r = new Random();
            while (integers.size() < 5) {
                integers.add(r.nextInt(20) + 1);
            }
            return integers;
        });
        //一个代表2018年4月1日的Calendar对象
        Calendar obj3 = getObj(() -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, 01, 16);
            return calendar;
        });


        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3.getTime());
    }
}
