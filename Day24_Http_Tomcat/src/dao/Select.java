package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-02-22 下午 08:51
 */
public class Select {
    public List<Users> query(Connection conn, String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT *FROM person WHERE username=? AND password=?";
        List<Users> query = qr.query(conn, sql, new BeanListHandler<>(Users.class), username, password);
        return query;
    }
}
