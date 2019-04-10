package top.niyueyeee;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;

/**
 * @author niyueyeee
 * @create 2019-02-26 20:49
 */
@WebServlet(urlPatterns = "/login")
public class lServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, parameterMap);

            boolean login = new Service().login(user);
            if (login) {
                System.out.println("成功");
                response.sendRedirect("/Day27/index.jsp");
            } else {
                System.out.println("用户名或密码错误");
                request.setAttribute("msg", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Test
        public void ee(){
            User u = new User();
            u.setUid("1");
            u.setUsername("admin");
            u.setPassword("admin");
            System.out.println(new Service().login(u));
        }
}
