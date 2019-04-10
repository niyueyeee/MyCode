import org.junit.Test;
import redis.clients.jedis.Jedis;
import utils.JedisUtils;

/**
 * @author niyueyeee
 * @create 2019-03-10 17:16
 */
public class RedisDemo {
    public static void main(String[] args) {
//        Jedis r = new Jedis("127.0.0.1", 6379);
        Jedis r = JedisUtils.getJedis();
        r.set("m","杨幂");
        System.out.println(r.get("m"));
        r.close();
    }
}
