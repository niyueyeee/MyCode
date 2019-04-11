/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 09:47
 */
public class Test09 {
    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
        for (int i = 1; i < 101; i++) {
            if (i%2==1){
                System.out.println("主线程"+i);
            }
        }
    }

    private static class MyThread extends Thread {
        public void run(){
            for (int i = 1; i < 101; i++) {
                if (i%2==0){
                    System.out.println("子线程"+i);
                }
            }
        }
    }
}
