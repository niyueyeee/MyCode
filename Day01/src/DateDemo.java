import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @authro niyueyeee
 * @create 2019-01-06 下午 09:46
 */
public class DateDemo {
//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
//        String format = sdf.format(new Date());
//        System.out.println(format);
//    }
public static void main(String[] args) {
    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(sim.format(new Date()));
}
}
