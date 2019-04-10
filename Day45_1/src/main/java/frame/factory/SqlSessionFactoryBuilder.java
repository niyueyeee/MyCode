package frame.factory;

import frame.pojo.Configuration;
import frame.utils.XmlConfigBuilder;

import java.io.InputStream;

/**
 * @author niyueyeee
 * @create 2019-03-27 11:18
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        Configuration configuration = XmlConfigBuilder.loadXmlConfig(inputStream);
        sqlSessionFactory.setConfiguration(configuration);
        return sqlSessionFactory;
    }
}
