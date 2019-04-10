import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 09:25
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\MyCode\\Day10\\src\\test.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\MyCode\\Day10\\src\\test1.txt"));
        ArrayList<String> arr = new ArrayList<>();
        String i;
        while ((i = br.readLine()) != null) {
            arr.add(i);

        }
        br.close();
        int num;
        Collections.reverse(arr);
        for (String s : arr) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
