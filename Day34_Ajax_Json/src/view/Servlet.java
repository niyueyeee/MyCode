package view;

import com.google.gson.Gson;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-09 10:43
 */
@WebServlet(urlPatterns = "/ss")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String keyword = request.getParameter("word");

        List<String> strings = new UserService().queryNameByKeyWord(keyword);

        String s = new Gson().toJson(strings);
        System.out.println(s);
        response.getWriter().write(s);
    }
}
