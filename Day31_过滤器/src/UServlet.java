import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author niyueyeee
 * @create 2019-03-04 19:59
 */
@WebServlet(urlPatterns = "/c")
public class UServlet extends BaseServlet {
    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加");
    }

    public void reg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("55");
    }
}
