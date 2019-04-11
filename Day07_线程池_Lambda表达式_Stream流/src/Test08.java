import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @authro niyueyeee
 * @create 2019-01-15 下午 09:36
 */
public class Test08 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        MyRunnable mr = new MyRunnable();
        es.submit(mr);
        es.submit(mr);
        es.submit(mr);

    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我需要一个老师");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("教我java,教完后，"+Thread.currentThread().getName()+"回到了办公室");
        }
    }
}
