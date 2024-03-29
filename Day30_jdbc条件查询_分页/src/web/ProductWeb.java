package web;

import domain.product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-01 21:04
 */
@WebServlet(urlPatterns = "/pic")
public class ProductWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List<product> pq = new ProductService().queryService();
        request.getSession().setAttribute("list", pq);
        response.sendRedirect(request.getContextPath() + "/product_list.jsp");
    }
}
