/**
 * @authro niyueyeee
 * @create 2019-01-15 上午 09:19
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Subrunnable sub = new Subrunnable();
        SuRunnable su = new SuRunnable();
        new Thread(sub,"jiaosha").start();
        new Thread(su,"shazi").start();
    }

    private static class Subrunnable implements Runnable {


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class SuRunnable extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
