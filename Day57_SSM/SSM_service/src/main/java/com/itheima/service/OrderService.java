package com.itheima.service;

import com.itheima.pojo.Order;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-16 21:34
 */
public interface OrderService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Order> findAll();

    /**
     * 保存订单
     *
     * @param order
     */
    void save(Order order);
}
