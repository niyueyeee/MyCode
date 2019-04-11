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
import java.util.ArrayList;
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
        User user = new User();
        user.setUsername("zzzzzzzzz");
        mapper.saveUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUsernameById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("范丞丞");
        user.setId(33);
        mapper.updateUsernameById(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryUserByWhere() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("%王%");
        List<User> users = mapper.queryUserByWhere(user);
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        List<User> users = mapper.queryUserByIds(integers);
        users.forEach(System.out::println);
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
        List<Orders> orders = mapper.queryOrdersUser();
        orders.forEach(System.out::println);
        sqlSession.close();
    }
}


