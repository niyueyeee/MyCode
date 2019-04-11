import java.io.FileInputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/a.txt");
        int i;
        byte[] b = new byte[1024];
        while (((i=fis.read(b))!=-1)){
            System.out.println(new String(b,0,i));
        }
        fis.close();
    }
}
