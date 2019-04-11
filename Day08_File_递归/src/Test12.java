import java.io.File;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 09:19
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        fun(file);

    }

    private static void fun(File file) {
        for (File li : file.listFiles()) {
            int i=0;
            if (li.isFile() && li.getName().endsWith(".java")) {
                System.out.println(li);
            } else if (li.isDirectory()){
                fun(li);
            }

        }
    }
}
