package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niyueyeee
 * @create 2019-04-12 20:07
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }
}
