import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @authro niyueyeee
 * @create 2019-01-06 下午 09:55
 */
public class DateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sim.parse("2018-03-04");
        System.out.println(parse);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd天");
        System.out.println(sd.format(parse));
    }
}
