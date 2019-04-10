import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 03:38
 */
public class Test16 {
    public static void main(String[] args) {
        Function<ArrayList<Integer>, Integer> f1 = a-> {
            int sum = 0;
            for (Integer d : a) {
                sum += d;
            }
            return sum / a.size();
        };
        Function<Map<String,Integer>,ArrayList<Integer>> f2 = map->{
            /*ArrayList<Integer> list = new ArrayList<>();
            for (String s : map.keySet()) {
                Integer i = map.get(s);
                list.add(i);
            }*/

            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(map.values());
            return list;
        };
        Map<String,Integer> map = new HashMap<>();
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);

        //利用Function求平均成绩  map > f2 > f1
        Integer avg = f2.andThen(f1).apply(map);
        System.out.println("学生平均成绩为："+avg);

    }
}
