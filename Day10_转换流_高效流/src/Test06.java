import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 08:37
 */
public class Test06 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\v.txt"), "GBK");
        int i = 0;
        while ((i = isr.read()) != -1) {
            System.out.print((char) i);
        }
        isr.close();
    }
}
