/**
 * @authro niyueyeee
 * @create 2019-01-16 下午 03:24
 */
public class Test12 {
    public static void main(String[] args) {
        getProducr(10, 10, (a, b) -> a * b);
    }

    static void getProducr(int a, int b, IntCalc intCalc) {
        System.out.println(intCalc.Calc(a, b));
    }

    public interface IntCalc {
        int Calc(int a, int b);
    }
}
