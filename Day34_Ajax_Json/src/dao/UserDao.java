package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-08 19:58
 */
public class UserDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    public List<String> queryNameByKeyWord(String KeyWord) throws SQLException {
        String sql = "SELECT name FROM user WHERE name LIKE ? LIMIT 4";
        Object[] params = {"%" + KeyWord + "%"};
        return qr.query(sql, new ColumnListHandler<>(), params);
    }
}
