import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * @authro niyueyeee
 * @create 2019-01-20 下午 08:56
 */
public class Test08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\a.txt"));
        Test07.student s = (Test07.student) ois.readObject();
        System.out.println(s.getName() + " " + s.getAge() + " " + s.getSex());
    }
}
