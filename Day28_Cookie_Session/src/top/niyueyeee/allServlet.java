package top.niyueyeee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-01 11:47
 */
@WebServlet(urlPatterns = "/in")
public class allServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("ll");

        String u = null;
        String p = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                System.out.println("zh" + cookie.getValue());
                u = cookie.getValue();
            }
            if (cookie.getName().equals("password")) {
                System.out.println("mm" + cookie.getValue());
                p = cookie.getValue();
            }

        }
        User user = new User();
        user.setUsername(u);
        user.setPassword(p);
        if (new Service().login(user)) {
            System.out.println("cookie成功");
            request.getSession().setAttribute("login", request.getParameter("username"));
            request.getSession().setAttribute("bj", 1);
            response.sendRedirect("/Day28/index.jsp");
        } else {
            System.out.println("cookie不成功");
            request.getSession().setAttribute("bj", 2);
            response.sendRedirect("/Day28/index.jsp");
        }

    }

}

