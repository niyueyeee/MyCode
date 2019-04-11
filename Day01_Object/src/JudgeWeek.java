import java.util.Calendar;

/**
 * @authro niyueyeee
 * @create 2019-01-07 上午 09:34
 */
public class JudgeWeek {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.YEAR,2019);
//        instance.set(9Calendar.MONTH,00);
//        instance.set(Calendar.DATE,07);
        instance.set(2019, 00, 07);
        char i = getweek(instance.get(Calendar.DAY_OF_WEEK));
        System.out.println(i);

    }

    private static char getweek(int i) {
        char[] c = {' ', '日', '一', '二', '三', '四', '五', '六'};
        return c[i];
    }
}