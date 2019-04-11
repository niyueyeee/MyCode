package service;

import dao.Select;
import org.apache.commons.dbutils.DbUtils;
import utils.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-22 下午 09:18
 */
public class Service {
    public int duibi (String username, String password) {
        Select select = new Select();
        Connection conn = null;
        try {
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            if (select.query(conn, username, password).size() > 0) {
                return 1;
            }
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollbackAndCloseQuietly(conn);
        }
        return 0;
    }

    public int duibiName(String username) {
        Select select = new Select();
        Connection conn = null;
        try {
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            if (select.queryUserName(conn, username).size() > 0) {
                return 1;
            }
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollbackAndCloseQuietly(conn);
        }
        return 0;
    }

    public void update(String username, String password) {
        Select select = new Select();
        Connection conn = null;
        try {
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            select.updateUser(conn, username, password);
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollbackAndCloseQuietly(conn);
        }
    }
}
