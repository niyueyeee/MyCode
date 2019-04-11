import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @authro niyueyeee
 * @create 2019-01-27 下午 10:07
 */
public class Test02 {
    @Test
    public void TryC() throws Exception {
        String url = "jdbc:mysql://localhost:3306/day15? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true ";
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            con = DriverManager.getConnection(url, "root", "00008888");
            stmt = con.createStatement();
            String sql = "select * from category";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString("cname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null)
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
