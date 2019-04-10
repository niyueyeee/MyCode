/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:55
 */
public class Test10 {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(jishu(24));
    }

    private static int jishu(int i) {

        if (i == 1 || i == 2) {
            return 1;
        } else {
            return jishu(i - 1) + jishu(i - 2);
        }

    }
}
