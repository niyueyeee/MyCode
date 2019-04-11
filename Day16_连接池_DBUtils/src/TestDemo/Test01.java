package TestDemo;

import domain.Users;
import utils.C3P0Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-01-28 上午 11:52
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        System.out.println(queryOneUserByUid("u001"));
        List<Users> list = quaryAllUsers();
        //遍历
        for (Users u : list) {
            System.out.println(u);
        }
    }

    public static List<Users> quaryAllUsers() throws SQLException {
        List<Users> userss = new ArrayList<>();
        Connection con = C3P0Util.getConnection();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from users ");
        Users user = null;
        while (res.next()) {
            String uid = res.getString("uid");
            String uname = res.getString("uname");
            String upass = res.getString("upass");
            user = new Users(uid, uname, upass);
            userss.add(user);
        }
        C3P0Util.close(res, stmt, con);
        return userss;
    }

    public static Users queryOneUserByUid(String uid) throws Exception {
        Connection con = C3P0Util.getConnection();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from users where uid='" + uid + "'");
        Users user = null;
        if (res.next()) {
            uid = res.getString("uid");
            String uname = res.getString("uname");
            String upass = res.getString("upass");
            user = new Users(uid, uname, upass);
        }
        C3P0Util.close(res, stmt, con);
        return user;
    }
}
