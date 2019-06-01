import com.itheima.config.SpringConfig;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 23:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void test() {
        List<Account> accounts = accountService.queryAccountList();
        accounts.forEach(System.out::println);
    }
}
