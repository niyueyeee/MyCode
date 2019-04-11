package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-13 上午 09:14
 */
public class TlAccountDao {
    public void outMoney(String from, double money) {
        QueryRunner qr = new QueryRunner();
        try {
            Connection conn = C3P0Util.getConnection();
            String sql = "update account set money = money - ? where name = ?";
            qr.update(conn, sql, money, from);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inMoney(String to, double money) {
        QueryRunner qr = new QueryRunner();
        try {
            Connection conn = C3P0Util.getConnection();
            String sql = "update account set money = money + ? where name = ?";
            qr.update(conn, sql, money, to);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
