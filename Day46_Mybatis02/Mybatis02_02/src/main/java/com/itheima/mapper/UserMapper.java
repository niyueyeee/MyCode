package com.itheima.mapper;

import com.itheima.pojo.User;
import com.itheima.pojo.UserVo;

import java.util.List;

/*
  用来完成 对 表user  进行操作的！！

     实现类 交给 mybatis产生 我这里只是声明方法



 */
public interface UserMapper {
    // 如果采用mapper动态方式 完成开发 那么方法 的定义必须遵守规则！！

    User queryUserById(Integer id);

    User queryUserByUserVo(UserVo userVo);

    List<User> queryList();

    List<User> queryUserByUsername(String s);

    void saveUser(User user);

    void updateUsernameById(User user);

    void deleteUserById(Integer integer);

}
