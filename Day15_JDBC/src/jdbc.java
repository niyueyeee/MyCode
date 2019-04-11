import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @authro niyueyeee
 * @create 2019-02-12 上午 11:07
 */
public class jdbc {
    //2.获取Connection对象
    //定义到数据库的连接地址
    private static String url;
    //定义用户名
    private static String userName;
    //定义密码
    private static String password;


    //构造方法私有
    private jdbc() {

    }
    //让注册驱动只执行一次
    static {
        //1.注册驱动
        try {
            //1.1 创建Properties对象
            Properties props = new Properties();

            //1.2 创建字节输入流对象绑定源文件
            InputStream is = new FileInputStream("D:\\MyCode\\Day15\\src\\config.properties");
            //加载src根目录下的文件的方式
//            InputStream is = jdbc.class.getClassLoader().getResourceAsStream("config.properties");
            System.out.println("yes");
            //1.3 Properties对象调用load方法传递字节输入流对象
            props.load(is);
            System.out.println("yes");
            //1.4 Properties对象调用getProperty方法,传递键获取值
            url = props.getProperty("url");
            userName = props.getProperty("user");
            password = props.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义静态方法,获取Connection对象
    public static Connection getConnection() throws Exception {

        Connection con = DriverManager.getConnection(url, userName, password);

        return con;
    }
    //定义方法,释放资源
    public static void close(ResultSet rs, Statement stmt, Connection con) {
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
