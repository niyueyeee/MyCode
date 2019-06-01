import java.io.FileInputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:/test.txt");
        aa(fis, 'a');
    }

    private static void aa(FileInputStream fis, char a) throws IOException {
        int j = 0;
        int i;

        while (((i = fis.read()) != -1)) {
//            System.out.println(i);
            if (a == i) {
                j++;
                System.out.println(j);
                if (j == 10) {
                    System.out.println("a出现" + j + "次");
                }
            }
        }
    }
}
