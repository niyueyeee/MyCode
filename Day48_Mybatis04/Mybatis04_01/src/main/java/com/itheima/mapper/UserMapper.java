package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

/*
  用来完成 对 表user  进行操作的！！

     实现类 交给 mybatis产生 我这里只是声明方法



 */
public interface UserMapper {

    /**
     * 根据多id查询用户列表
     */
    User queryUserById(Integer id);

    /**
     * 一对多关联查询
     * 查询全部用户数据 关联订单数据
     */
    List<User> queryUserOrders();

}
