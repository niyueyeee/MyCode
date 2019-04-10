package TestDemo;

import utils.JDBCUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 08:15
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String userName = sc.nextLine();
        System.out.println("请输入用密码: ");
        String password = sc.nextLine();

        Connection con = JDBCUtil.getConnection();
        String sql = "select * from users where uname=? and upass=?";
        CallableStatement psmt = con.prepareCall(sql);
        psmt.setObject(1, userName);
        psmt.setObject(2, password);

        ResultSet rs = psmt.executeQuery();
        if(rs.next()) {
            System.out.println("登录成功~~~~~~~");
        } else {
            System.out.println("登录失败~~~~~~~");
        }
        JDBCUtil.close(rs, psmt, con);
    }
}
