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
 * @create 2019-02-22 下午 05:40
 */
@WebServlet(urlPatterns = "/Servlet")
public class Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int duibi = new Service().duibi(name, password);
        if (duibi==1){
            response.getWriter().print("登陆成功");
        }else {
            response.getWriter().print("登陆失败");
        }
    }
    @Test
    public void ss(){
        System.out.println(new Service().duibi("admin","admin"));
    }
}
