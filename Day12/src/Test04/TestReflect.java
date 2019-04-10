package Test04;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @authro niyueyeee
 * @create 2019-01-24 上午 09:28
 */
public class TestReflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Properties props = new Properties();
        InputStream in = TestReflect.class.getClassLoader().getResourceAsStream("Test04\\config.properties");
        props.load(in);
        String className = props.getProperty("className");
        String methodName = props.getProperty("methodName");
        Class<?> c = Class.forName(className);
        Method method = c.getMethod(methodName);
        Object o = c.newInstance();
        method.invoke(o);
    }
}
