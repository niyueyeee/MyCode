import java.io.File;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-18 上午 09:03
 */
public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        System.out.println(fun(file));
    }

    private static int fun(File file) {
        int num = 0;
        for (File listFile : file.listFiles()) {
            if (listFile.isFile()) {
                num += listFile.length();
            } else {
                num += fun(listFile);
            }
        }
        return num ;
    }
}
