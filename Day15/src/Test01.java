import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @authro niyueyeee
 * @create 2019-01-27 下午 09:10
 */
public class Test01 {
    @Test
    public void Query() throws Exception {
        String url = "jdbc:mysql://localhost:3306/day15? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true";
        Connection con = DriverManager.getConnection(url, "root", "00008888");
        Statement stat = con.createStatement();
        String sql = "select * from category";
        ResultSet resultSet = stat.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("cname"));
        }
        resultSet.close();
        stat.close();
        con.close();
    }

    @Test
    public void Add() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/day15? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true";
        Connection con = DriverManager.getConnection(url, "root", "00008888");
        Statement stmt = con.createStatement();
        String sql = "INSERT INTO category  (cid,cname) VALUES(\"c004\",\"玩具\")";
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.println("ok");
        } else {
            System.out.println("no ok");
        }
        stmt.close();
        con.close();
    }

    @Test
    public void Update() throws Exception {
        String url = "jdbc:mysql://localhost:3306/day15? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true";
        Connection con = DriverManager.getConnection(url, "root", "00008888");
        Statement stmt = con.createStatement();
        String sql = "UPDATE category SET cname=\"成人用品\" WHERE cid=\"c004\"";
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.println("ok");
        } else {
            System.out.println("no ok");
        }
        stmt.close();
        con.close();
    }

    @Test
    public void Delete() throws Exception {
        String url = "jdbc:mysql://localhost:3306/day15? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true";
        Connection con = DriverManager.getConnection(url, "root", "00008888");
        Statement stmt = con.createStatement();
        String sql = "ALTER TABLE category CHANGE `name`  cname VARCHAR(50) ";
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.println("ok");
        } else {
            System.out.println("no ok");
        }
        stmt.close();
        con.close();
    }
}
