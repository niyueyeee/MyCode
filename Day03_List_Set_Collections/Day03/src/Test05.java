
import java.util.LinkedList;

/**
 * @authro niyueyeee
 * @create 2019-01-09 下午 08:04
 */
public class Test05 {
    public static void main(String[] args) {
        LinkedList<String> lin = new LinkedList<>();
        lin.add("aaa");
        lin.add("bbb");
        lin.add("ccc");
        System.out.println(lin);
        lin.set(0, "aa");
        System.out.println(lin);
        lin.get(0);
        System.out.println(lin);
        lin.remove(0);
        System.out.println(lin);
        int i = lin.size();
        System.out.println(i);
//        lin.clear();
        System.out.println(lin);
        lin.addFirst("11");
        System.out.println(lin);
        lin.addLast("21");
        System.out.println(lin);
        lin.getFirst();
        lin.getLast();
        lin.removeFirst();
        lin.removeLast();
        lin.pop();
        lin.push("aa");
    }
}
