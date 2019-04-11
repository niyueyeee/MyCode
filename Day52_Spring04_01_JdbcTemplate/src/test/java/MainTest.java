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
 * @create 2019-04-06 19:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MainTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void test() throws Exception {
        List<Account> accounts = accountService.queryAccountByList();
        accounts.forEach(System.out::println);
    }

    @Test
    public void test1() throws Exception {
        Account account = accountService.queryAccountById(7);
        System.out.println(account);
    }
}
