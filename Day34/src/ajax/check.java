package ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-09 15:25
 */
@WebServlet(urlPatterns = "/check")
public class check extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        //2:判断用户名是不是jack  如果是jack说明存在
        if("jack".equals(username)){
            //说明jack存在
            response.getWriter().write('1');
        }else{
            response.getWriter().write('0');
        }
    }
}
