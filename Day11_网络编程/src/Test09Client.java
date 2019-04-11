import java.io.*;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-23 下午 07:56
 */
public class Test09Client {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\a.flv");
        if (!f.exists()) {
            return;
        }
        if (!f.getName().endsWith(".flv")) {
            return;
        }
        if (f.length() < 1024 * 1024 * 2) {
            return;
        }
        FileInputStream fis = new FileInputStream(f);
        Socket sc = new Socket("127.0.0.1", 9989);
        OutputStream os = sc.getOutputStream();

        byte[] bytes = new byte[8096];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        sc.shutdownOutput();
        InputStream is = sc.getInputStream();
        int read = is.read(bytes);
        System.out.println(new String(bytes, 0, read));
        os.close();
        is.close();
        fis.close();

    }
}
