import java.io.File;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:30
 */
public class Test07 {
    public static void main(String[] args) {
        File f = new File("d:/ccc/a.txt");
        if (f.isFile()) {
            System.out.println(f.getName()+"是一个文件");
        } else if (!f.isFile()) {
            System.out.println(f.getName()+"不是一个文件");
        } else if (f.isDirectory()) {
            System.out.println(f.getName()+"是一个文件夹");
        } else {
            System.out.println(f.getName()+"不是一个文件夹");
        }
    }
}
