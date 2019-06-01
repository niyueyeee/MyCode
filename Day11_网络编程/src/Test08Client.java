import java.io.*;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-23 上午 11:55
 */
public class Test08Client {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\a.jpg"));
        Socket sc = new Socket("127.0.0.1", 8888);
        InputStream is = sc.getInputStream();
        OutputStream os = sc.getOutputStream();
        byte[] bytes = new byte[1024];
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte[] by = new byte[80906];
        int len = 0;
        while ((len = bis.read(by)) != -1) {
            bos.write(by, 0, len);
        }
        sc.shutdownInput();
        System.out.println("ok");
        int read = is.read(by);
        System.out.println(new String(by));
        is.close();
        sc.close();
        bis.close();

    }
}
