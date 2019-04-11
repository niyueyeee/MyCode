import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:/a.txt");
        fos.write("i love java".getBytes());
        fos.close();
    }
}
