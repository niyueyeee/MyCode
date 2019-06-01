import java.io.File;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 08:39
 */
public class Test09 {
    public static void main(String[] args) {
        System.out.println("Please address");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());
//        System.out.println(f.getName());
        if (f.isFile()) {
            System.out.println(f.length());
        } else {
            int i = 0;
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    i += file.length();
                }
            }
            System.out.println(i);
        }
    }
}
