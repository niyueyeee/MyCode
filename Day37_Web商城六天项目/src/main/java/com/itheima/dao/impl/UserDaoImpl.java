package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    /**
     * 完成用户的注册
     * @param u
     * @throws SQLException
     */
    public void register(User u) throws SQLException {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {u.getUid(),u.getUsername(),u.getPassword(),
                           u.getName(),u.getEmail(),u.getBirthday(),
                           u.getGender(),u.getState(),u.getCode(),
                           u.getRemark()};
        // 执行
        qr.update(sql,params);
    }
   // 根据用户名和密码 获取登录人信息
    @Override
    public User login(String username, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";

        Object[] params = {username,password};
        return qr.query(sql, new BeanHandler<>(User.class), params);
    }
}
