package service;

import dao.AccountDao;
import org.apache.commons.dbutils.DbUtils;
import utils.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 10:01
 */
public class AccountService {
    public void transfer(String from, String to, double money) {
        AccountDao accountDao = new AccountDao();
        Connection conn = null;
        try {
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            accountDao.inMoney(conn, to, money);
            accountDao.outMoney(conn, from, money);
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollbackAndCloseQuietly(conn);
        }
    }
}
