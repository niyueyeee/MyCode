package top.niyueyeee;

import utils.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-02-26 21:19
 */
public class Service {
    //登录
    public boolean login(User user) {
        try {
            Connection conn = C3P0Util.getConnection();
            User u = new Dao().queryOne(conn, user);
            return u != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //注册
    public boolean register(User user) {
        try {
            Connection conn = C3P0Util.getConnection();
            if (new Dao().queryOneByName(conn, user) != null) {
                return false;
            }
            return new Dao().insterPerson(conn, user) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
