
import java.util.ArrayList;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 12:30
 */
public class ArrayListZhuanArr {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(132);
        list.add(12);
        list.add(13);
        int[] i = zhuan(list);
        for (int i1 : i) {
            System.out.println(i1);
        }
    }

    private static int[] zhuan(ArrayList<Object> list) {
        int num = list.size();
        int[] i = new int[num];
        for (int i1 = 0; i1 < list.size(); i1++) {
            i[i1] = (int) list.get(i1);
        }
        return i;
    }
}
