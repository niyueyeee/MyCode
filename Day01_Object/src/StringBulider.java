/**
 * @authro niyueyeee
 * @create 2019-01-07 上午 10:20
 */
public class StringBulider {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        textString();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        long start1 = System.currentTimeMillis();
        textStringBuilder();
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }

    private static void textString() {
        String s = "hello";
        for (int i = 0; i < 1000000; i++) {
            s +="word";
        }
}
    private static void textStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder("hello");
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("word");

        }
        String s = stringBuilder.toString();
    }
}

