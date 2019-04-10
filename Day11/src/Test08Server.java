import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-23 上午 11:54
 */
public class Test08Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket accept = ss.accept();
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\aa.jpg"));
        byte[] bytes = new byte[80960];
        int len=0;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        System.out.println("ok");
        OutputStream os = accept.getOutputStream();
        os.write("ok".getBytes());
        os.close();
        bis.close();accept.close();

    }
}
