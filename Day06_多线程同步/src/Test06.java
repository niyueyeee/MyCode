
/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 11:05
 */
public class Test06 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "子线程执行");
                }
            }
        }, "z").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "子线程执行");
                }
            }
        }, "a").start();
        while (true) {
            System.out.println("主线程执行");
        }

    }
}
