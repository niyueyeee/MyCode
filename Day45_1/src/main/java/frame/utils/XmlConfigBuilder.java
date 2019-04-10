package frame.utils;

import frame.pojo.Configuration;
import frame.pojo.Mapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class XmlConfigBuilder {

    /**
     *    方法的目的
     *       解析xml 返回配置信息对象！！
     *         参数
     *            InputStream
     *               这个流代表着 读取 到xml的那个流
     * @param inputStream
     * @return
     */
    public static Configuration  loadXmlConfig(InputStream inputStream){
        Configuration configuration = new Configuration();
        // 解析xml
        // 1:new SAXReader对象
        SAXReader saxReader = new SAXReader();
        // 流 是关联 xml的
        try {
            // 2: 获取流 加载 配置文件 并返回一个document对象
            Document document = saxReader.read(inputStream);
            // 3: 获取 根元素
            Element rootElement = document.getRootElement();
            // 4: 观察发现  ！  需要解析的标签 都叫property
            //  怎么找到 所有的property标签
            List<Element> elementList =  rootElement.selectNodes("//property");

            // 5: 遍历得到 每一个标签
            for (Element element : elementList) {
                //element  就是每一个property标签
                //  <property name="username" value="root" />
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");

                if(name.equalsIgnoreCase("driver")){
                    // 设置到 driver中
                    configuration.setDriver(value);
                }

                if(name.equalsIgnoreCase("url")){
                    // 设置到 driver中
                    configuration.setUrl(value);
                }

                if(name.equalsIgnoreCase("username")){
                    // 设置到 driver中
                    configuration.setUsername(value);
                }

                if(name.equalsIgnoreCase("password")){
                    // 设置到 driver中
                    configuration.setPassword(value);
                }

            }

            // 解析出所有的存放sql语句的xml文件
            List<Element> mapperList =  rootElement.selectNodes("//mapper");
            //遍历
            if(mapperList!=null && mapperList.size()>0){
                for (Element mapper : mapperList) {
                    // 它的路径
                    String mapperPath = mapper.attributeValue("resource");

                    // 有了路径 那可以根据路径解析了！！！
                    loadSqlConfig(configuration,mapperPath);
                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }



        return configuration;
    }

    public  static void loadSqlConfig(Configuration configuration,String mapperPath) {
        // 解析 需要的之  namespace  每个sql配置中 id resultType属性以及 标签体sql语句
        InputStream inputStream = XmlConfigBuilder.class.getClassLoader()
                .getResourceAsStream(
                        mapperPath);

        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(inputStream);
            // 获取 根标签
            Element rootElement = document.getRootElement();
            // 获取根标签中 namespace 属性
            String namespace = rootElement.attributeValue("namespace");

            // 获取所有select
            List<Element> selectList = rootElement.selectNodes("//select");

            for (Element element : selectList) {
                // 获取id属性
                String id = element.attributeValue("id");
                // 获取resultType
                String resultType = element.attributeValue("resultType");

                // 获取 标签体
                String sql = element.getText();
                // 封装mapper
                Mapper mapper = new Mapper();
                mapper.setSql(sql);
                mapper.setResultType(resultType);

                // 保存  键值对  namespace+"."+id作为键   mapper做值
                configuration.getMapperMap().put(namespace+"."+id,mapper);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
