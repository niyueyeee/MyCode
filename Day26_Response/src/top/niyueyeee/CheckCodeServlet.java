package top.niyueyeee;

 import utils.ImgUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @authro niyueyeee
 * @create 2019-02-25 下午 09:06
 */
@WebServlet(urlPatterns = "/lunbo")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 1. 定义基本字符串 , 字符的来源.
        String STR = new String("1234567890qwertyuiopasdfghjklzxcvbnm");

        // 2. 随机拼4个为一串
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        /*
          StringBuilder 拼接字符串 , append(参数) , 参数进行追加似的拼接.

          a.append(b)  --> ab  ab.append(c)  --> abc
         */
        for (int i = 0; i < 4; i++) {
            char c = STR.charAt(random.nextInt(STR.length()));
            stringBuilder.append(c);
        }
        BufferedImage checkImg = ImgUtils.getCheckImg(stringBuilder.toString());
        // 3. 将图片回写到页面 .
        /*
        ImageIO.write 方法, 将图片 写出到 指定位置 .
        第一个参数:  图片对象.
        第二个参数 :  图片的扩展名
        第三个参数 :  输出流 , 指定输出位置 .

         */
        ImageIO.write(checkImg, "jpg", response.getOutputStream());
    }
}
