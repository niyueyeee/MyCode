import java.util.concurrent.*;

/**
 * @authro niyueyeee
 * @create 2019-01-15 下午 08:29
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(200);
        MyRunnable r = new MyRunnable();
//        service.submit(r);
        Callable<Double> c = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return Math.random();
            }
        };
        Future<Double> f1 = service.submit(c);
        System.out.println(f1.get());
        Future<Double> f2 = service.submit(c);
        System.out.println(f2.get());
        Future<Double> f3 = service.submit(c);
        System.out.println(f3.get());
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
