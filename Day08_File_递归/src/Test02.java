import java.io.File;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:12
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
