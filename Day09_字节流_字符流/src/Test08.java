import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("d:/score.txt"));
        for (String s : prop.stringPropertyNames()) {
            System.out.println(s + " " + prop.getProperty(s));
            if (s.equals("lisi")) {
                System.out.println("----------");
                prop.setProperty(s, "100");
            }
        }
        prop.store(new FileOutputStream("d:/score1.txt"), "haha");
    }
}

