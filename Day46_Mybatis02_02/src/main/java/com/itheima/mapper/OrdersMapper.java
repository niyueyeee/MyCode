package com.itheima.mapper;

import com.itheima.pojo.Orders;
import com.itheima.pojo.User;
import com.itheima.pojo.UserVo;

import java.util.List;

/*
  用来完成 对 表orders  进行操作的！！

     实现类 交给 mybatis产生 我这里只是声明方法



 */
public interface OrdersMapper {

    //查询所有订单信息
    List<Orders> queryOrdersByList();
}
