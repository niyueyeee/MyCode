import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import utils.JedisUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-03-10 19:52
 */
@WebServlet(urlPatterns = "/s")
public class s extends BaseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("登录");
        Jedis jedis = JedisUtils.getJedis();
        String s = jedis.get("s");
        String s1 = new Gson().toJson(s);
        resp.getWriter().write(s1);

    }

    public void reg(HttpServletRequest req, HttpServletResponse reps) {
        System.out.println("注册");
    }
}
