import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* @author niyueyeee
 * @create 2019-03-26 20:27
 */
public class test {
    @Test
    public void test() throws IOException {
        //  1 创建工程队对象  SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //  2 调用build方法 传入 input流 得到 一个SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //  3 通过SqlSessionFactory对象调用openSession 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //  4 执行 selectList(SqlId)方法 得到 结果集 解析
        List<Object> objects = sqlSession.selectList("userMapper.queryList");
        objects.forEach(System.out::println);
        //  5 释放资源
        sqlSession.close();
    }
}
