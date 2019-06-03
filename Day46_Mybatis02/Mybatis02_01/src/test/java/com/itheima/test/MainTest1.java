package com.itheima.test;

import com.itheima.Dao.UserDaoImpl;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-27 20:17
 */
public class MainTest1 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void bufore() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        inputStream.close();
    }

    @Test
    public void queryUserByList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoImpl userDao = new UserDaoImpl(sqlSession);
        List<User> users = userDao.queryUserByList();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}

