/**
 * @authro niyueyeee
 * @create 2019-01-15 下午 09:15
 */
public class Test06 {

    public int start = 1;
    public int end = 99;

    public static void main(String[] args) {
        new Test06().method();
    }

    public void method() {
        //请在此处插入代码，实现打印输出1-99。


        Runnable a = () -> {
            for (int i = start; i <= end; i++) {
                System.out.println(i);

            }
        };
        Thread t = new Thread(a);
        t.start();
    }

}
