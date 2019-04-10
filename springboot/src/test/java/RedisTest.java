import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.MySpringBootApplication;
import com.itheima.pojo.Account;
import com.itheima.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 13:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class RedisTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        String s = redisTemplate.boundValueOps("account.findAll").get();
        if (s == null) {
            List<Account> all = accountRepository.findAll();
            s = new ObjectMapper().writeValueAsString(all);
            redisTemplate.boundValueOps("account.findAll").set(s);
            System.out.println("=======从数据库中获得user的数据======");
        } else {
            System.out.println("=======从redis缓存中获得user的数据======");
        }
        System.out.println(s);
    }
}
