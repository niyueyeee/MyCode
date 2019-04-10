package web;

import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-02 20:17
 */
@WebServlet(urlPatterns = "/dlProduct")
public class dlproduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (new ProductService().dlService(request.getParameter("pid"))) {
            request.getRequestDispatcher("/adminQueryAll").forward(request, response);
        }
    }
}
