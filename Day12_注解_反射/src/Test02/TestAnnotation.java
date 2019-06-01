package Test02;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @authro niyueyeee
 * @create 2019-01-23 下午 09:40
 */
public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        System.out.println("---------获取成员方法上注解的数据----------");
        test01();
    }

    /**
     * 获取BookStore类成员方法buyBook使用的Book注解数据
     */
    public static void test01() throws Exception {
        // 获得BookStore类对应的Class对象
        Class<BookStore> c = BookStore.class;
        // 获得成员方法buyBook对应的Method对象
        Method m = c.getMethod("buyBook");
        // 判断成员方法buyBook上是否使用了Book注解
        if (m.isAnnotationPresent(Book.class)) {
            // 根据注解Class对象获取注解对象
            Book book = m.getAnnotation(Book.class);
            // 输出book注解属性值
            System.out.println("书名:" + book.value());
            System.out.println("价格:" + book.price());
            System.out.println("作者:" + Arrays.toString(book.authors()));
        }
    }
}
