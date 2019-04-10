package com.itheima.dao;

/*
   操作数据库的接口
       这里只定义方法

         由具体的实现类实现
 */

import com.itheima.domain.Category;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Orders;
import com.itheima.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    // 保存订单信息
    void saveOrders(Orders orders) throws SQLException;

    //保存订单项信息
    void saveOrderItem(OrderItem orderItem) throws SQLException;

    //查询数量
    long totalByUid(String uid) throws Exception;

    //查询分页
    List<Orders> findByPage(String uid, int pageNumber, int pageSize) throws Exception;

    //查询订单
    Orders info(String oid) throws Exception;

    // 发起支付的时候 更新订单信息 更新地址 电话 收货人
    void updateOrders(String oid, String address, String name, String telephone) throws SQLException;

    // 支付成功之后 改变订单状态
    void updateState(String oid) throws SQLException;

}
