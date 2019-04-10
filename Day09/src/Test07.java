import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        FileWriter fos = new FileWriter("d:/a.txt", true);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入：");
            String s = sc.nextLine();
            if (s.equals("886")) {
                System.out.println("err");
                break;
            }
            fos.write(s);
            fos.write("\r\n");

        }
        fos.close();
    }
}
