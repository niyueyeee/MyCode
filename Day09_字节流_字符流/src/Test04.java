import java.io.FileInputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/a.txt");
        int i;
        while (((i = fis.read()) != -1)) {
            System.out.println((char) i);
        }
        fis.close();
    }
}
