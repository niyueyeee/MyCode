package com.itheima.mapper;

import com.itheima.pojo.Orders;

import java.util.List;

/*
  用来完成 对 表orders  进行操作的！！

     实现类 交给 mybatis产生 我这里只是声明方法



 */
public interface OrdersMapper {
    /**
     * 一对一关联查询
     * 查询全部用户数据 关联订单数据
     */
    List<Orders> queryOrdersUser() ;
}
