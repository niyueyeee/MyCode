package dao;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 09:53
 */
public class AccountDao {
    /*** 付款方法
     * @param conn 连接对象
     * @param from 付款人
     * @param money 金额 */
    public void outMoney(Connection conn, String from, double money) {
        QueryRunner qr = new QueryRunner();
        try {
            String sql = "update account set money=money-? where name=?";
            qr.update(conn, sql, money, from);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*** 收款方法
     * @param conn 连接对象
     * @param from 收款人
     * @param money 金额 */
    public void inMoney(Connection conn, String from, double money) {
        QueryRunner qr = new QueryRunner();
        try {
            String sql = "update account set money=money+? where name=?";
            qr.update(conn, sql, money, from);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
