import java.sql.*;


/**
 * @authro niyueyeee
 * @create 2019-01-28 上午 08:59
 */
public class JDBCUtil {
    private static final String url = "jdbc:mysql://localhost:3306/day16? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true ";
    private static final String userName = "root";
    private static final String password = "00008888";

    private JDBCUtil() {
    }

    static {
        try {
            DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, userName, password);

        return con;
    }

    public static void close(ResultSet rs, Statement stmt, Connection con){
        if(rs!=null) {
            try {
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(stmt!=null) {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(con!=null) {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
