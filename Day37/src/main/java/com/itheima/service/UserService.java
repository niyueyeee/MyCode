package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {


    /**
     * 完成用户的注册
     * @param user

     */
    void register(User user);
    /*
      用户登陆
     */
    User login(String username,String password);
}
