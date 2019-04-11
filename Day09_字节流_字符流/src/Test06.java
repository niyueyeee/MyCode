import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-01-18 下午 07:48
 */
public class Test06 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:/a.jpg");
        FileOutputStream fos = new FileOutputStream("d:/a.jpg");
        int i;
        while (((i=fis.read())!=-1)){
            fos.write(i);
        }
        fos.close();
        fis.close();
    }
}
