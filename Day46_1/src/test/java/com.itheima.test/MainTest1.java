package com.itheima.test;

import com.itheima.mapper.OrdersMapper;
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
 * @create 2019-03-27 21:20
 */
public class MainTest1 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //获取 工程队对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 工厂类对象
        sqlSessionFactory = builder.build(inputStream);
        inputStream.close();
    }

    @Test
    public void queryOrdersByList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper userMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = userMapper.queryOrdersByList();
        orders.forEach(System.out::println);
        sqlSession.close();
    }

}
