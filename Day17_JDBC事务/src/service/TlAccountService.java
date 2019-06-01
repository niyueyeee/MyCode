package service;

import dao.TlAccountDao;
import utils.TlManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-13 上午 09:13
 */
public class TlAccountService {
    public void transfer(String from, String to, double money) {
        TlAccountDao tlAccountDao = new TlAccountDao();
        Connection conn = null;
        try {
            conn = TlManager.getConnection();
            TlManager.setAutoCommit();
            tlAccountDao.outMoney(from, money);
            tlAccountDao.inMoney(to, money);
            TlManager.Commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                TlManager.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                TlManager.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
