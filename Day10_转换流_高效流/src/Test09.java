import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 09:17
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream("Day10\\src\\d.txt"));
        Scanner sc = new Scanner(System.in);
        ps.println(sc.nextLine());
        ps.close();
    }
}
