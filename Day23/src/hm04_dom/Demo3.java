package hm04_dom;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo3 {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document dom = saxReader.read("D:\\MyCode\\Day23\\src\\bean.xml");

       // 使用 XPath 格式 , 解析元素

//        List<Element> list = dom.selectNodes("/beans/bean/property");
//        System.out.println(list.size());
//        for (Element element : list) {
//            System.out.println(element.attributeValue("name"));
//            System.out.println(element.attributeValue("value"));
//        }


        // 使用bean id = 002
        Element e  = (Element) dom.selectSingleNode("//bean[@id='002']");

        System.out.println(e);

        String id = e.attributeValue("id");

        System.out.println(id);
    }
}
