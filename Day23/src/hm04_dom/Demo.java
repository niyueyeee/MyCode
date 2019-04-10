package hm04_dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo{
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document dom = saxReader.read("D:\\MyCode\\Day23\\src\\bean.xml");
        Element rootElement = dom.getRootElement();
        List<Element> elements = rootElement.elements();
        System.out.println(elements.size());
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("className");
            System.out.println(id+className);
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                String name = element1.attributeValue("name");
                String value = element1.attributeValue("value");
                System.out.println(name+value);
            }
        }
    }
}