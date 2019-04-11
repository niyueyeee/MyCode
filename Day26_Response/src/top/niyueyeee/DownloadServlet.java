package top.niyueyeee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-02-25 下午 08:06
 */
@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 1.获取参数  , 获取真实路径.
        String filename = request.getParameter("filename");
        // 2. 设置头
        String realPath = getServletContext().getRealPath("/download/" + filename);
        // 2.1  MIME Type 类型,通知浏览器 返回文件的类型 .
        String mimeType = getServletContext().getMimeType(filename);
        // 2.2 设置类型 .
        String header = response.getHeader(mimeType);
        // 2.3 设置处置方式
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        // 3. io读写图片
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte[] bytes = new byte[8 * 1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();

    }
}
