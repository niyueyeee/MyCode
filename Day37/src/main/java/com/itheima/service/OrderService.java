package com.itheima.service;

import com.itheima.domain.OrderItem;
import com.itheima.domain.Orders;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    // 保存订单信息
    void saveOrders(Orders orders);

    //保存订单项信息
    void saveOrderItem(OrderItem orderItem);

    //查询分页
    PageBean<Orders> findByPage(String uid, int pageNumber, int pageSize);

    //查询订单
    Orders info(String oid);

    // 发起支付的时候 更新订单信息 更新地址 电话 收货人
    void updateOrders(String oid, String address, String name, String telephone);

    // 支付成功之后 改变订单状态
    void updateState(String oid);
}
