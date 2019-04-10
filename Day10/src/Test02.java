import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 07:54
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:/e.txt"));
        bos.write("i love java".getBytes());
        bos.close();
    }
}
