

/**
 * @authro niyueyeee
 * @create 2019-01-14 上午 11:09
 */
public class Test08 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("zi"+"  "+i);
                }
            }
        }).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("zhu"+"  "+i);
        }
    }
}
