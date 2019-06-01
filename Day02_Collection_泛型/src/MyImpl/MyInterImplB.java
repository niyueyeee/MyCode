package MyImpl;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 08:42
 */
public class MyInterImplB<T> implements Myinter<T> {

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}
