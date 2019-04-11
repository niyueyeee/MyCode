package TestDemo;

import domain.Users;
import org.junit.jupiter.api.Test;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utils.JDBCUtil.getConnection;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 08:22
 */
public class Test03 {
    @Test
    public void addOne() throws Exception {
        Connection con = getConnection();
        String sql = "insert into users(uid,uname,upass) values(?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setObject(1, "u005");
        psmt.setObject(2, "baoqiang");
        psmt.setObject(3, "baoqiang");
        int rows = psmt.executeUpdate();
        //6.处理结果
        if (rows > 0) {
            System.out.println("添加成功~~~~~~~");
        } else {
            System.out.println("添加失败~~~~~~~");
        }
        //7.关闭资源
        JDBCUtil.close(null, psmt, con);
    }

    @Test
    public void updateOne() throws Exception {
        Connection con = getConnection();

        //2.定义sql语句,参数先使用?代替
        String sql = "update users set uname=?,upass=? where uid=?";

        //3.Connection对象获取执行sql语句的PreparedStatement对象传递sql语句
        PreparedStatement pstmt = con.prepareStatement(sql);

        //4.PreparedStatement对象调用方法,给sql语句中的?赋值
        pstmt.setObject(1, "yangmi");
        pstmt.setObject(2, "yangmi");
        pstmt.setObject(3, "u004");
        int rows = pstmt.executeUpdate();
        //6.处理结果
        if (rows > 0) {
            System.out.println("修改成功~~~~~~~");
        } else {
            System.out.println("修改失败~~~~~~~");
        }
        //7.关闭资源
        JDBCUtil.close(null, pstmt, con);
    }

    @Test
    public void queryOne() throws Exception {
        Connection con = getConnection();
        String sql = "select * from users where uid=?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setObject(1, "u001");
        ResultSet rs = psmt.executeQuery();
        if (rs.next()) {
            String uid = rs.getString("uid");
            String uname = rs.getString("uname");
            String upass = rs.getString("upass");
            Users users = new Users(uid, uname, upass);
            System.out.println(users);
        } else {
            System.out.println("没有数据");
        }
        JDBCUtil.close(rs, psmt, con);
    }

    @Test
    public void queryAll() throws Exception {
        Connection con = getConnection();
        String sql = "select * from users";
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        List<Users> list = new ArrayList<>();
        while (rs.next()) {
            String uid = rs.getString("uid");
            String uname = rs.getString("uname");
            String upass = rs.getString("upass");
            Users users = new Users(uid, uname, upass);
            list.add(users);
        }
        JDBCUtil.close(rs, psmt, con);
        if (list.size() == 0) {
            System.out.println("没有数据");
        } else {
            for (Users u : list) {
                System.out.println(u);
            }
        }
    }
}
