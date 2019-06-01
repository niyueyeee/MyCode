package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

/*
  用来完成 对 表user  进行操作的！！

     实现类 交给 mybatis产生 我这里只是声明方法



 */
public interface UserMapper {
    // 查询所有
    List<User> queryList();

    /**
     * 根据用户性别和用户名称查询用户列表
     */
    List<User> queryUserByWhere(User user);

    /**
     * 根据多个 id查询用户列表
     * 多个id使用集合存储的
     */
    List<User> queryUserByIds(List<Integer> ids);

    /**
     * 根据多个 id查询用户列表
     * 传递的是数组
     */
    List<User> queryUserByArray(int[] array);

    /**
     * 一对多关联查询
     * 查询全部用户数据 关联订单数据
     */
    List<User> queryUserOrders();

}
