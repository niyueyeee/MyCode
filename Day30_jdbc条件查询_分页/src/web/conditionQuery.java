package web;

import domain.conditionProduct;
import domain.product;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author niyueyeee
 * @create 2019-03-02 21:05
 */
@WebServlet(urlPatterns = "/conditionQuery")
public class conditionQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> pm = request.getParameterMap();
        conditionProduct cp = new conditionProduct();
        try {
            BeanUtils.populate(cp, pm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<product> products = new ProductService().conditionService(cp);
        request.setAttribute("list", products);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
    }
}
