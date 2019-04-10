import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 07:49
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/d.txt"));
        bos.write(97);
        bos.close();
    }
}
