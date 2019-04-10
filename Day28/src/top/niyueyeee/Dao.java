package top.niyueyeee;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author niyueyeee
 * @create 2019-02-26 21:19
 */
public class Dao {
    //查询一个数据
    public User queryOne(Connection conn,User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT *FROM person WHERE username=? AND password=?";
        return qr.query(conn,sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
    }
    //按名字查询
    public User queryOneByName(Connection conn,User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT *FROM person WHERE username=?";
        return qr.query(conn,sql, new BeanHandler<>(User.class), user.getUsername());
    }
    //添加一个数据
    public int insterPerson(Connection conn, User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO person VALUES(null,?,?)";
        return qr.update(conn, sql,  user.getUsername(), user.getPassword());
    }
}
