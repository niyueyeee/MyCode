import java.io.*;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 07:58
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\a.jpg"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\a.jpg"));
        int b = 0;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bis.close();
        bos.close();
    }
}
