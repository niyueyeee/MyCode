package com.itheima.test;

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
public class MainTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void bufore() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        inputStream.close();
    }

    @Test
    public void queryUserByList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> objectList = sqlSession.selectList("test.queryList");
        objectList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User objectList = sqlSession.selectOne("test.queryUserById", 1);
        System.out.println(objectList);
        sqlSession.close();
    }
    @Test
    public void queryUserByUsername() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.queryUserByUsername", "%王%");
        userList.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void saveUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("nini");
        user.setSex("1");
        user.setAddress("asas");
        user.setBirthday(new Date());
        sqlSession.insert("test.saveUser", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void updateUsernameById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("nn222i");
        user.setId(27);
        sqlSession.update("test.updateUsernameById", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void deleteUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(27);
        sqlSession.update("test.deleteUserById", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }
}

