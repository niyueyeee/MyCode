import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:/a.txt", true);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("please:");
            String s = sc.nextLine();
            if (s.equals("end")) {
                System.out.println("err");
                break;
            }
            fw.write(s);
            fw.write("\r\n");
            System.out.println("----------");
        }
        fw.close();
    }
}
