package web;

import domain.PageBean;
import org.junit.jupiter.api.Test;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-03 15:02
 */
@WebServlet(urlPatterns = "/page")
public class pageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String c = request.getParameter("currentPage");
        if (c == null) {
            c = "1";
        }
        PageBean fenye = new ProductService().fenye(c);
        System.out.println(fenye);
        request.setAttribute("pageBean", fenye);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
    @Test
    public void sss(){
        System.out.println(new ProductService().fenye("1"));
    }
}
