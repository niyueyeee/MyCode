import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-21 下午 08:06
 */
public class Test05 {
    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(8888);
                    Socket ac = ss.accept();
                    InputStream is = ac.getInputStream();
                    while (true) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = is.read(buffer)) != -1) {
                            System.out.println(new String(buffer, 0, len));
                        }
                        is.close();
                    }
                } catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println(System.currentTimeMillis());
                }
            }
        }).start();

    }

}
