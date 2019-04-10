import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-30 20:07
 */
public class MainTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        inputStream.close();
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void queryUserOrders() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUserOrders();
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryOrdersUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = mapper.queryOrdersUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
