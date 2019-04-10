package view;

import org.junit.jupiter.api.Test;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @authro niyueyeee
 * @create 2019-02-25 上午 09:26
 */
@WebServlet(urlPatterns = "/reg")
public class vreg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        int username = new Service().duibiName(request.getParameter("name"));
        if (username == 1) {
            response.getWriter().print("用户名已存在");
        } else if (request.getParameter("name") == "" || request.getParameter("password") == "") {
            response.getWriter().print("用户名或密码不能为空");
            System.out.println("request = [" + request + "], response = [" + response + "]");
        } else {
            new Service().update(request.getParameter("name"), request.getParameter("password"));
            response.getWriter().print("注册成功");

        }
    }

    @Test
    public void vv() {
        System.out.println(new Service().duibiName("admin"));
    }
}
