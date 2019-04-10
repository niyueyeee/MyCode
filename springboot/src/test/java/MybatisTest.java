import com.itheima.MySpringBootApplication;
import com.itheima.mapper.AccountMapper;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 12:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class MybatisTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void test() {
        List<Account> accounts = accountMapper.queryAccountList();
        System.out.println(accounts);
    }
}
