package top.niyueyeee;


import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author niyueyeee
 * @create 2019-02-27 17:37
 */
@WebServlet(urlPatterns = "/register")
public class rServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, parameterMap);

            boolean register = new Service().register(user);
            if (register && user.getUsername() != "" && user.getPassword() != "") {
                System.out.println("成功");
                Cookie cookie = new Cookie("card", user.getUsername());

                // 设置路径.
//                cookie.setPath("/Day28/login");
                // 回写
                response.addCookie(cookie);

                request.getSession().setAttribute("card", user.getUsername().toString());

                response.sendRedirect("/Day28/login.jsp");
            } else {
                System.out.println("用户名重复");
                request.setAttribute("msg", "用户名重复");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    private void ee() {
        User u = new User();
        u.setUsername("2");
        u.setPassword("2");
        System.out.println("55");
        System.out.println(new Service().register(u));
    }
}
