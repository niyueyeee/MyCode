import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-23 上午 11:35
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        ServerSocket sc = new ServerSocket(8802);
        Socket ac = sc.accept();
        InputStream is = ac.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        is.close();
        sc.close();
    }

    public class TCPServer {
        public void main(String[] args) throws Exception {
            //1创建服务器对象
            ServerSocket ss = new ServerSocket(8002);
            //2等待客户端连接      如果有客户端连接     获取到客户端对象
            Socket socket = ss.accept();
            //3当前在服务器中     将数据写到流中
            OutputStream out = socket.getOutputStream();
            out.write("hello world".getBytes());
            //释放资源
            out.close();
//	      ss.close();服务器一般不会关闭
        }
    }
}
