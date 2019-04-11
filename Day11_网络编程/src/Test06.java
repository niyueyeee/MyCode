import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-23 上午 11:29
 */
public class Test06 {
    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Socket sc = new Socket("127.0.0.1", 8888);
                    OutputStream os = sc.getOutputStream();
                    while (true) {
                        System.out.println("请输入:");
                        Scanner ssc = new Scanner(System.in);
                        os.write(ssc.nextLine().getBytes());

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

