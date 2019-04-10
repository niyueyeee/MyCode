import java.io.File;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-17 下午 09:53
 */
public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        fun(file);
    }

    private static void fun(File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isFile()){
                listFile.delete();
            }else {
                fun(listFile);
            }
            listFile.delete();
        }
    }
}
