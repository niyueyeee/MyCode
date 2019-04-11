import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 08:31
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\v.txt"),"GBK");
        osw.write("nihao八四u不丢阿巴斯");
        osw.close();
    }
}
