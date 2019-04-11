package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Orders;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    //通过 工具类结合配置文件 获取接口的子类对象
    private OrderDao orderDao = BeanFactory.newInstance(OrderDao.class);

    // 保存 订单信息
    @Override
    public void saveOrders(Orders orders) {

        try {
            orderDao.saveOrders(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //保存订单项信息
    @Override
    public void saveOrderItem(OrderItem orderItem) {

        try {
            orderDao.saveOrderItem(orderItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrders(String oid, String address, String name, String telephone) {
        try {
            orderDao.updateOrders(oid, address, name, telephone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateState(String oid) {
        try {
            orderDao.updateState(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询订单
    @Override
    public Orders info(String oid) {
        Orders orders = null;
        try {
            orders = orderDao.info(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    //查询分页
    @Override
    public PageBean<Orders> findByPage(String uid, int pageNumber, int pageSize) {
        PageBean<Orders> pb = new PageBean<>();
        try {
            pb.setPageSize(pageSize);
            pb.setPageNumber(pageNumber);
            pb.setTotal((int) orderDao.totalByUid(uid));
            pb.setTotalPage((int) Math.ceil(((int) orderDao.totalByUid(uid) * 1.0) / pageSize));
            pb.setData(orderDao.findByPage(uid, pageNumber, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pb;
    }
}
