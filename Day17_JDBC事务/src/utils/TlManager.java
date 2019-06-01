package utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authro niyueyeee
 * @create 2019-02-13 上午 09:06
 */
public class TlManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public TlManager() {
    }

    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = C3P0Util.getConnection();
            tl.set(con);
        }
        return con;
    }

    public static void setAutoCommit() throws SQLException {
        Connection con = getConnection();
        con.setAutoCommit(false);
    }

    public static void Commit() throws SQLException {
        Connection con = getConnection();
        con.commit();
    }

    public static void rollback() throws SQLException {
        Connection con = getConnection();
        con.rollback();
    }

    public static void close() throws SQLException {
        Connection con = getConnection();
        con.close();
        tl.remove();
    }
}
