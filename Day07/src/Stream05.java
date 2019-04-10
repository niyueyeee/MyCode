import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @authro niyueyeee
 * @create 2019-01-17 上午 11:54
 */
public class Stream05 {
    public static void main(String[] args) {
        ArrayList<Test17.Students> arr = new ArrayList<>();
        Collections.addAll(arr, new Test17.Students("谢霆锋", 85)
                , new Test17.Students("刘亦菲", 77)
                , new Test17.Students("黄晓明", 33)
                , new Test17.Students("岑小村", 92)
                , new Test17.Students("章子怡", 63));
        Collections.sort(arr, new Comparator<Test17.Students>() {
            @Override
            public int compare(Test17.Students o1, Test17.Students o2) {
                return (int) (o1.getSroce()-o2.getSroce());
            }
        });
        Collections.sort(arr, ( o1, o2)->
                (int) (o1.getSroce()-o2.getSroce())

        );
//        Collections.sort(arr, Comparator.comparingInt(Test17.Students::getSroce));


        arr.stream().forEach(students -> System.out.println(students.getName()+students.getSroce()));
    }
}
