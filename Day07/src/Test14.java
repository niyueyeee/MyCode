import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 03:38
 */
public class Test14 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        //key:姓名 value:成绩
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);


        //打印谷天洛的分数
        doJob(map, (s) -> System.out.println(s.get("谷天洛")));
        //打印最高分
        doJob(map, (s) -> {
            int a = 0;
            for (Integer value : s.values()) {
                if (value > a) {
                    a = value;
                }
            }
            System.out.println(a);
        });
        //分别以60分和70分为及格线，打印及格的人的名字(组合型消费)
        doJob(map,
                (s) -> {
                    for (Map.Entry<String, Integer> st : s.entrySet()) {
                        if (st.getValue() > 60) {
                            System.out.println(st.getKey());
                        }
                    }


                },
                (s) -> {
                    for (Map.Entry<String, Integer> st : s.entrySet()) {
                        if (st.getValue() > 70) {
                            System.out.println(st.getKey());
                        }
                    }

                });
    }

    public static <T> void doJob(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T> void doJob(T t, Consumer<T> consumer1, Consumer<T> consumer2) {
        consumer1.andThen(consumer2).accept(t);
    }
}

