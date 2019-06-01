package top.niyueyeee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-01 10:46
 */
@WebServlet(urlPatterns = "/zhuxiao")
public class zServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("msg", "余额不足");
//        2. 通过Session 获取 JSESSIONID .
        String id = session.getId();
        System.out.println(id);
//        3. 创建Cookie ,  键必须是 JSESSIONID
        Cookie jsessionid = new Cookie("JSESSIONID", id);

//        4. cookie时间 设置足够长  1分钟
        jsessionid.setMaxAge(0);

//        5. .把JSESSIONID 存到 cookie中 ,回写
        response.addCookie(jsessionid);
        response.sendRedirect("/Day28/index.jsp");
    }
}
