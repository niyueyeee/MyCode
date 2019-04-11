import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-04 20:23
 */
@WebFilter(urlPatterns = "/*")
public class filter implements Filter {
    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("过滤");
        chain.doFilter(req, resp);
    }


}
