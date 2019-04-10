package Day02.MyImpl;

/**
 * @authro niyueyeee
 * @create 2019-01-07 下午 08:48
 */
public class TestDemo {
    public static void main(String[] args) {
        MyInterImplA myInterImplA = new MyInterImplA();
        myInterImplA.print("hahaz");
        MyInterImplB<String> objectMyInterImplB = new MyInterImplB<>();
        objectMyInterImplB.print("hahaa");
    }
}
