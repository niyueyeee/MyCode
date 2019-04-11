import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:34
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:/a.txt");
        fos.write("a".getBytes());
        fos.close();
    }
}
