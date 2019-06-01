package top.niyueyeee;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.Map;

/**
 * @author niyueyeee @create 2019-02-26 20:49
 */
@WebServlet(urlPatterns = "/login")
public class lServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");/*        Cookie[] cookies = request.getCookies(); //没Cookie if (cookies == null || cookies.length == 1) {*/
        try {
            Object code = request.getSession().getAttribute("code-Session");
            if (code.equals(request.getParameter("code"))) {
                Map<String, String[]> parameterMap = request.getParameterMap();
                User user = new User();
                BeanUtils.populate(user, parameterMap);
                boolean login = new Service().login(user);
                if (login) {
                    System.out.println("成功");
                    Cookie username_cookie = new Cookie("username", request.getParameter("username"));
                    Cookie password_cookie = new Cookie("password", request.getParameter("password"));
                    username_cookie.setMaxAge(1000 * 60 * 60); //
                    password_cookie.setMaxAge(1000 * 60 * 60); //
                    //     添加到响应中
                    response.addCookie(username_cookie);
                    response.addCookie(password_cookie);
                    request.getSession().setAttribute("login", request.getParameter("username"));
                    response.sendRedirect("/Day28/index.jsp");
                } else {
                    System.out.println("用户名或密码错误");
                    request.setAttribute("msg", "用户名或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("msg1", "验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }/*        } //有cookie else { //            String cookie_username =null; //            String cookie_password =null; // [username = tom  ,  password=123] // 之前登录过 , 获取保存的数据 , 并校验 for (Cookie cookie : cookies) { // username  tom System.out.println(cookie.getName() + " -- " + cookie.getValue()); if ("username".equals(cookie.getName())) { // tom String cookie_username = cookie.getValue(); } if ("password".equals(cookie.getName())) { // 123 String cookie_password = cookie.getValue(); } } User u = new User(); u.setUsername("cookie_username"); u.setPassword("cookie_password"); if (new Service().login(u)) { System.out.println("有Cookie登录成功"); request.getSession().setAttribute("login", request.getParameter("username")); response.sendRedirect("/Day28/index.jsp"); } else { System.out.println("有Cookie用户名或密码错误"); request.setAttribute("msg", "有Cookie用户名或密码错误"); request.getRequestDispatcher("/login.jsp").forward(request, response); } }*/
    }

    @Test
    public void ee() {
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        System.out.println(new Service().login(u));
    }
}
