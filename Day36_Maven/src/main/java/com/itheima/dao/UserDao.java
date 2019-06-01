package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-03-11 20:38
 */
public class UserDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    public void save(User user) throws SQLException {
        String sql = "insert into user (id,name,source,industry,level,phone)values(?,?,?,?,?,?)";
        Object[] params = {user.getId(), user.getName(), user.getSource(), user.getIndustry(), user.getLevel(), user.getPhone()};

        qr.update(sql, params);
    }
}
