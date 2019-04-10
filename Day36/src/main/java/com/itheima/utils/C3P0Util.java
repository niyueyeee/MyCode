package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    C3P0连接池工具类
 */
public class C3P0Util {
    //创建C3P0连接池对象,自动读取src根目录下的c3p0.properties或者c3p0-config.xml配置文件
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    private C3P0Util() {

    }

    //定义方法,获取连接池对象
    public static DataSource getDataSource() {
        return cpds;
    }

    //定义静态方法,获取连接对象
    public static Connection getConnection() throws SQLException {

        //连接池对象调用getConnection方法获取连接对象
        Connection con = cpds.getConnection();

        //返回Connection对象

        return con;
    }
    //定义方法,释放资源
    public static void close(ResultSet rs, Statement stmt, Connection con) {
        if(rs!=null) {
            try {
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(stmt!=null) {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(con!=null) {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
