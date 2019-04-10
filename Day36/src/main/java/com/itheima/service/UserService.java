package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-03-11 20:38
 */
public class UserService {
    private UserDao u = new UserDao();

    public void save(User user){
        try {
            u.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
