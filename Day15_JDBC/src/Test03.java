import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @authro niyueyeee
 * @create 2019-01-28 上午 09:16
 */
public class Test03 {
    @Test
    public void JDBCcon() {
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            con = jdbc.getConnection();
            System.out.println(con);
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from users");
            while (res.next()) {
                System.out.println(res.getString("uid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbc.close(res, stmt, con);
        }
    }
}
