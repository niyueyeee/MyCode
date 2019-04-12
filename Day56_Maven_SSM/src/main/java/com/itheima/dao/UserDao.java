package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @author niyueyeee
 * @create 2019-04-12 19:59
 */
public interface UserDao {
    public User findById(Integer id);
}
