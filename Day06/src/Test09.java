

/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 11:12
 */
public class Test09 {
    public static void main(String[] args) {
        Tunnel tul = new Tunnel();
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(tul, "p" + i);
            t.start();
        }
    }

    private static class Tunnel implements Runnable {
        private int crossNum = 0;

        @Override
        public void run() {
//            cross();
            synchronized (this) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 1.3.2 改变通过的人次
                crossNum++;
                // 1.3.3 打印线程名称及其通过隧道的顺序，模拟人通过隧道及其顺序
                System.out.println(Thread.currentThread().getName() + "已经通过隧道，TA是第" + crossNum + "通过的！");
            }
        }

        public synchronized void cross() {
            // 1.3.1 子线程睡眠5秒钟，模拟每个人通过隧道需要5秒钟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 1.3.2 改变通过的人次
            crossNum++;
            // 1.3.3 打印线程名称及其通过隧道的顺序，模拟人通过隧道及其顺序
            System.out.println(Thread.currentThread().getName() + "已经通过隧道，TA是第" + crossNum + "通过的！");
        }

    }
}
