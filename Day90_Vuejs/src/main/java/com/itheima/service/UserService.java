package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-09 18:12
 */
public interface UserService {

    List<User> finaAll();

    User findById(Integer id);

    void update(User user);
}
