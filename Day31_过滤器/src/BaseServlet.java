
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

// 不需要配置路径.
public abstract class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /*
         当 多个方法 实现后,  需要多个if 去判断 . 非常麻烦 ,继续优化.

         如果我们个知道方法名 ,就能调用该方法, 不要判断就好了.

         反射 !  解析类 , 获取 Method /Constructor / Filed



       */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodName = request.getParameter("method");
        // 反射 执行 此 method
        // 1. 获取 Class

        // 2. 获取Method
        Class clz = this.getClass();
        try {
            Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 3. 执行method  ,invoke
            method.invoke( this ,  request, response );


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
