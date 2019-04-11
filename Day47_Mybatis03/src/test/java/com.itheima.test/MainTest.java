package com.itheima.test;

import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.Role;
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
 * @create 2019-03-28 21:21
 */
public class MainTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
        inputStream.close();
    }

    @Test
    public void queryUserByList() {
        // 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取接口实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用功能
        List<User> userList = mapper.queryList();

        userList.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void queryUserByWhere() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setSex("1");
        user.setUsername("%王%");
        List<User> users = mapper.queryUserByWhere(user);
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> objects = new ArrayList<>();
        objects.add(28);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        List<User> users = mapper.queryUserByIds(objects);
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserByArray() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int[] arrayList = {2, 3, 4};
        List<User> users = mapper.queryUserByArray(arrayList);
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

    @Test
    public void queryRoleUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.queryRoleUser();
        roles.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserRole() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<User> users = mapper.queryUserRole();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
