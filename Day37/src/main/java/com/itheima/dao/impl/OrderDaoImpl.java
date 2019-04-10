package com.itheima.dao.impl;

import com.itheima.constant.Constant;
import com.itheima.dao.OrderDao;
import com.itheima.domain.OrderItem;
import com.itheima.domain.OrderItemView;
import com.itheima.domain.OrderItemView;
import com.itheima.domain.Orders;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    // 保存 订单信息
    @Override
    public void saveOrders(Orders orders) throws SQLException {
        String sql = "insert into orders (oid,ordertime,total,state,uid)values(?,?,?,?,?)";

        Object[] params = {orders.getOid(), orders.getOrdertime(), orders.getTotal(),
                orders.getState(), orders.getUid()};

        qr.update(sql, params);

    }

    //保存订单项信息
    @Override
    public void saveOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "insert into orderitem values(?,?,?,?)";

        Object[] params = {orderItem.getCount(), orderItem.getSubTotal(), orderItem.getPid(),
                orderItem.getOid()};

        qr.update(sql, params);
    }

    //查询数量
    @Override
    public long totalByUid(String uid) throws Exception {
        String sql = "select count(*) from orders where uid=?";
        Object[] params = {uid};
        return qr.query(sql, new ScalarHandler<>(), params);
    }

    @Override
    public void updateOrders(String oid, String address, String name, String telephone) throws SQLException {
        String sql = "update orders set address=?,name=?,telephone=? where oid=?";
        Object[] params = {address,name,telephone,oid};

        qr.update(sql,params);
    }

    @Override
    public void updateState(String oid) throws SQLException {
        String sql = "update orders set state = ? where oid=?";
        Object[] params = {Constant.YI_FU_KUAN,oid};

        qr.update(sql,params);
    }

    //查询订单
    @Override
    public Orders info(String oid) throws Exception {
        String sql = "select * from orders where oid = ?";
        Orders query = qr.query(sql, new BeanHandler<>(Orders.class), oid);
        String sql2 = "SELECT p.pid,p.pimage,p.pname,p.shop_price,o.count,o.subtotal FROM product p ,orderitem o \n" +
                "             WHERE p.pid=o.pid AND o.oid=?";
        List<OrderItemView> query1 = qr.query(sql2, new BeanListHandler<>(OrderItemView.class), query.getOid());
        query.setOrderItemViews(query1);
        return query;
    }

    //查询分页
    @Override
    public List<Orders> findByPage(String uid, int pageNumber, int pageSize) throws Exception {
        String sql1 = "select * from orders where uid = ? limit ?,?";
        Object[] params = {uid, (pageNumber - 1) * pageSize, pageSize};
        List<Orders> query = qr.query(sql1, new BeanListHandler<>(Orders.class), params);
        for (Orders orders : query) {
            String sql2 = "SELECT p.pid,p.pimage,p.pname,p.shop_price,o.count,o.subtotal FROM product p ,orderitem o WHERE p.pid=o.pid AND o.oid=?";
            List<OrderItemView> query1 = qr.query(sql2, new BeanListHandler<>(OrderItemView.class), orders.getOid());

            orders.setOrderItemViews(query1);
        }
        return query;
    }
}
