package com.itheima.test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.pojo.UserVo;
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
 * @create 2019-03-27 21:20
 */
public class MainTest {
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
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(28);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void queryUserByList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.queryList();
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void queryUserByUsername() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.queryUserByUsername("%王%");
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void saveUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("赵小云");
        user.setSex("1");
        user.setAddress("常小山");
        user.setBirthday(new Date());
        userMapper.saveUser(user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void updateUsernameById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("赵小云");
        user.setId(28);
        userMapper.updateUsernameById(user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryUserByUserVo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserVo userVo = new UserVo();
        User user = new User();
        user.setId(28);
        userVo.setUser(user);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserByUserVo(userVo);
        System.out.println(user1);
        sqlSession.close();
    }
}
