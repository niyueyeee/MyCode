import java.io.File;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:35
 */
public class Test08 {
    public static void main(String[] args) {
        File f = new File("d:/ccc");
        for (File file : f.listFiles()) {
            System.out.println(file);
        }
    }
}
