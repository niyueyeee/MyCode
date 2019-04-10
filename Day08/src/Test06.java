import java.io.File;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:25
 */
public class Test06 {
    public static void main(String[] args) {
        File file = new File("d:/ccc/a.txt");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());
        System.out.println(file.length());
    }
}
