package cn.itcast.service;

import cn.itcast.pojo.User;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-04 19:55
 */
public interface UserService {
    User findById(int id);

    List<User> findAll();
    List<User> findAll2();
    void update();
}
