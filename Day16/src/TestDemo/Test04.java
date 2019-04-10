package TestDemo;

import domain.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @authro niyueyeee
 * @create 2019-02-12 下午 09:02
 */
public class Test04 {
    @Test
    public void addOne() throws SQLException {
        QueryRunner qr = new QueryRunner();
        int update = qr.update(C3P0Util.getConnection(), "insert into users(uid,uname,upass) values(?,?,?)", "u006", "root", "root");
        if (update > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    @Test
    public void updateOne() throws SQLException {
        QueryRunner qr = new QueryRunner();
        int update = qr.update(C3P0Util.getConnection(), "update users set uname=?,upass=? where uid=?",
                new String[]{"baoqiang", "qiangbao", "u002"});
        if (update > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

    //删除一条记录
    @Test
    public void deleteOne() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        //2.QueryRunner对象调用update方法,sql语句,?对应的数据 获取结果
        int rows = qr.update("delete from users where uid=?", "u002");
        //3.处理结果
        if (rows > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void queryAll() throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Users> list = qr.query(C3P0Util.getConnection(), "select * from users", new BeanListHandler<>(Users.class));
        for (Users user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void queryOne() throws SQLException {
        QueryRunner qr = new QueryRunner();
        Users u = qr.query(C3P0Util.getConnection(), "select *from users where uid=?", new BeanHandler<>(Users.class), "u001");
        System.out.println(u);
    }

    @Test
    public void query01() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner();

        //2.QueryRunner对象调用query方法,传递连接对象,sql语句,结果集处理器对象,?对应的数据 获取结果
        //List<Object> list = qr.query(C3P0Util.getConnection(), "select * from users", new ColumnListHandler());//uid列
        //List<Object> list = qr.query(C3P0Util.getConnection(), "select * from users", new ColumnListHandler(2));//uname列
        Object list = qr.query(C3P0Util.getConnection(), "select * from users", new ColumnListHandler("upass"));//upass列
        //3.处理结果
        System.out.println(list);
    }

    /*
         获取查询结果只有一条记录时,某个字段的值
         ScalarHandler结果集处理器
         构造方法:
         public ScalarHandler(): 第一个字段的值
         public ScalarHandler(int columnIndex): 参数int数字代表的字段对应的值
         public ScalarHandler(String columnName): 参数String代表的字段对应的值
     */
    @Test
    public void query02() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner();

        //2.QueryRunner对象调用query方法,传递连接对象,sql语句,结果集处理器对象,?对应的数据 获取结果
        //Object value = qr.query(C3P0Util.getConnection(), "select * from users where uid=?", new ScalarHandler(), "u001");//uid字段
        //Object value = qr.query(C3P0Util.getConnection(), "select * from users where uid=?", new ScalarHandler(2), "u001");//uname字段
        Object value = qr.query(C3P0Util.getConnection(), "select * from users where uid=?", new ScalarHandler("upass"), "u001");//upass字段
        //3.处理结果
        System.out.println(value);
    }

    /*
         ScalarHandler结果集处理器
         主要应用场景: 获取只有一个结果的场景  聚合函数

     */
    @Test
    public void query03() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner();

        //2.QueryRunner对象调用query方法,传递连接对象,sql语句,结果集处理器对象,?对应的数据 获取结果
        Object value = qr.query(C3P0Util.getConnection(), "select count(*) from users", new ScalarHandler());//第一个字段
        //3.处理结果
        System.out.println(value);
    }
}

