import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authro niyueyeee
 * @create 2019-01-23 下午 07:56
 */
public class Test09Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9989);
        while (true){
            new Thread(new Runnable() {
                Socket accept = ss.accept();
                @Override
                public void run() {

                    try {

                        InputStream is = accept.getInputStream();
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\a.flv"));
                        int len=0;
                        byte[] bytes = new byte[8096];
                        while ((len=is.read(bytes))!=-1){
                            bos.write(bytes,0,len);
                        }
                        OutputStream os = accept.getOutputStream();
                        os.write("ok".getBytes());
                        is.close();
                        bos.close();
                        accept.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }
}}
