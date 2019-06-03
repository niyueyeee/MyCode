package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-04-03 20:49
 */
@Component("transcationManager")
public class TranscationManager {
    @Autowired
    @Qualifier("connectionUtil")
    public ConnectionUtil connectionUtil;

    public void begin() throws SQLException {
        connectionUtil.getConnection().setAutoCommit(false);
    }

    // 提交事务
    public void commit() throws SQLException {
        connectionUtil.getConnection().commit();
    }

    //回滚事务
    public void rollback() throws SQLException {
        connectionUtil.getConnection().rollback();
    }

    // 释放资源 并解除绑定
    public void close() throws SQLException {
        connectionUtil.getConnection().close();

        connectionUtil.remove();
    }

}
