import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @authro niyueyeee
 * @create 2019-01-08 下午 02:52
 */
class Genericity<T> {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        method(a, 0, 3);
        System.out.println();
        method1(a);
    }

    private static <E> void method1(E[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            E temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    private static <E> void method(E[] e, int a, int b) {
        E temp = e[a];
        e[a] = e[b];
        e[b] = temp;
        for (E e1 : e) {
            System.out.print(e1 + " ");

        }
    }
}
