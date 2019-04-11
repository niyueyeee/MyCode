package com.itheima.Dao;

import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-27 20:11
 */
public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> queryUserByList() throws Exception {
        List<User> list = sqlSession.selectList("test.queryList");
        return list;
    }
}
