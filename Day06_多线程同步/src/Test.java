import java.util.ArrayList;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-01-14 下午 08:17
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        zuobaozi zuo = new zuobaozi(list);
        chibaozi chi = new chibaozi(list);
        new Thread(zuo, "老板1").start();
//        new Thread(zuo, "老板2").start();
        new Thread(chi, "顾客1").start();
//        new Thread(chi, "顾客2").start();
//        new Thread(chi, "顾客3").start();
//        new Thread(chi, "顾客4").start();
//        new Thread(chi, "顾客5").start();
    }

    private static class chibaozi implements Runnable {
        private List<String> str;

        public chibaozi(List<String> str) {
            this.str = str;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (str) {
                    if (str.size() == 0) {
                        try {
                            str.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //有:
                    //吃一个包子
                    String st = str.remove(0);
                    System.out.println(Thread.currentThread().getName()
                            + "吃了" + st);
                    //唤醒包子铺包一个包子
                    str.notify();
                }
            }
        }
    }

    private static class zuobaozi implements Runnable {
        private List<String> str;

        public zuobaozi(List<String> str) {
            this.str = str;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (str) {
                    if (str.size() == 1) {
                        try {
                            str.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //无:
                    //做一个包子
                    str.add("a");
                    System.out.println(Thread.currentThread().getName()
                            + "做了" + str);
                    //唤醒吃一个包子
                    str.notify();
                }
            }
        }
    }
}
