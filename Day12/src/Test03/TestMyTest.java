package Test03;

import java.lang.reflect.Method;

/**
 * @authro niyueyeee
 * @create 2019-01-24 上午 09:16
 */
public class TestMyTest {
    public static void main(String[] args) throws Exception {
        Class c = MyTestDemo.class;
        Method[] methods = c.getMethods();
        Object obj = c.newInstance();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MyTest.class)){
                m.invoke(obj);
            }
        }
    }
}
