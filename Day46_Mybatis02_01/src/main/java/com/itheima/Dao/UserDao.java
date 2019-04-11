package com.itheima.Dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-27 20:10
 */
public interface UserDao {
    List<User> queryUserByList() throws Exception;
}
