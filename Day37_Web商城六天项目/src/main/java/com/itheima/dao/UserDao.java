package com.itheima.dao;

/*
   操作数据库的接口
       这里只定义方法

         由具体的实现类实现
 */

import com.itheima.domain.User;

import java.sql.SQLException;

public interface UserDao {

    /**
     * 完成用户的注册
     * @param user
     * @throws SQLException
     */
     void register(User user) throws SQLException;

    /**
     * 根据用户名和密码 获取登录人信息
     * @param username
     * @param password
     * @throws SQLException
     */
     User login(String username, String password)throws SQLException;

}
