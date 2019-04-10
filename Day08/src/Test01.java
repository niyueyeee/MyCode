import java.io.File;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:05
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建文件对象：绝对路径
        File f1 = new File("d:/a.txt");
        // 创建文件对象：相对路径
        File f2 = new File("a.txt");
        System.out.println(f2.toPath());
    }
}
