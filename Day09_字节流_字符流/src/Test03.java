import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:/a.txt", true);
        fos.write("i love java".getBytes());
        fos.write("\r\n".getBytes());
        fos.write("i love java".getBytes());
        fos.write("\r\n".getBytes());
        fos.write("i love java".getBytes());
        fos.write("\r\n".getBytes());
        fos.write("i love java".getBytes());
        fos.write("\r\n".getBytes());
        fos.write("i love java".getBytes());
        fos.write("\r\n".getBytes());
        fos.close();
    }
}
