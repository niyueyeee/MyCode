package hm04_dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws DocumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        SAXReader saxReader = new SAXReader();
        Document dom = saxReader.read("D:\\MyCode\\Day23\\src\\bean.xml");
        Element root = dom.getRootElement();

        List<Element> elements = root.elements();
        for (Element element : elements) {
            String className = element.attributeValue("className");
            Class aClass = Class.forName(className);
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                String name = element1.attributeValue("name");
                String value = element1.attributeValue("value");
                Field declaredField = aClass.getDeclaredField(name);
                Object o = aClass.newInstance();
                declaredField.setAccessible(true);
                declaredField.set(o,value);
                System.out.println(o);
            }
        }
    }
}
