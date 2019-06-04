package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-04 19:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findAll2() {
        return userMapper.findAll();
    }

    @Override
    @Transactional
    public void update() {
        User user = userDao.findById(2).get();
        user.setUsername("小ss黄....");

        userDao.save(user);

        int i=5/0;
    }
}
