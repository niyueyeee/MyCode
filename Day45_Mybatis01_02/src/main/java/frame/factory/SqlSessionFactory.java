package frame.factory;

import frame.core.SqlSession;
import frame.core.SqlSessionImpl;
import frame.pojo.Configuration;

/**
 * @author niyueyeee
 * @create 2019-03-27 9:57
 */
public class SqlSessionFactory {
    public Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession(){
        SqlSessionImpl sqlSession = new SqlSessionImpl();
        sqlSession.setConfiguration(configuration);
        return sqlSession;
    }
}
