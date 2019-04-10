package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    //通过 工具类结合配置文件 获取接口的子类对象
    private UserDao userDao = BeanFactory.newInstance(UserDao.class);

    /**
     * 完成用户的注册
     * @param user

     */
    @Override
    public void register(User user) {

        try {
            userDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = null;

        try {
            user = userDao.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
