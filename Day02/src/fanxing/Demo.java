package Day02.fanxing;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 08:19
 */
public class Demo {
    public static void main(String[] args) {
        Myclass01<String> mc01 = new Myclass01<>();
        mc01.setT("haha");
        System.out.println(mc01.getT());

        Myclass01<Integer> mc02 = new Myclass01<>(1000);
        System.out.println(mc02.getT());
    }
}
