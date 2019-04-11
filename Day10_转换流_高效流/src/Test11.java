import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 09:45
 */
public class Test11 {
    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:\\MyCode\\Day10\\src\\d.txt"));

        ArrayList<Test07.student> arr = new ArrayList<>();
        Collections.addAll(arr,
                new Test07.student("zs", "18", "nan"),
                new Test07.student("lisi", "19", "nan"),
                new Test07.student("wh", "18", "nv"));
        oos.writeObject(arr);
        oos.close();
    }
}
