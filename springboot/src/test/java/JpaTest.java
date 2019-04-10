import com.itheima.MySpringBootApplication;
import com.itheima.pojo.Account;
import com.itheima.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 13:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class JpaTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void test() {
        List<Account> all = accountRepository.findAll();
        System.out.println(all);
    }
}
