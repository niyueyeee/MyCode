/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 10:06
 */
public class Test11 {
    public static void main(String[] args) {
        new T1().start();
        new T2().start();
        new T3().start();
    }

    private static class T1 extends Thread {
        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                Integer a = i;
            }
            long m = System.currentTimeMillis();
            System.out.println(("线程1执行时间：" + (m - l)));
        }
    }

    private static class T2 extends Thread {
        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                String b = "黑马程序员";
            }
            long m = System.currentTimeMillis();
            System.out.println(("线程2执行时间：" + (m - l)));
        }
    }

    private static class T3 extends Thread {
        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                String c = "黑马程序员" + i;
            }
            long m = System.currentTimeMillis();
            System.out.println(("线程3执行时间：" + (m - l)));
        }
    }
}
