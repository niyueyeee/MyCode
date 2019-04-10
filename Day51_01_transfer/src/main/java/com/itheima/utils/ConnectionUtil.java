package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-04-03 20:37
 */
@Component("connectionUtil")
public class ConnectionUtil {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection==null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    public void remove(){
        threadLocal.remove();
    }
}
