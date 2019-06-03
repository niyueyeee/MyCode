import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 21:20
 */
public class MainTest {
    @Test
    public void save() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContest.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        Account account = new Account();
        account.setName("zhang");
        account.setMoney(111.55f);
        accountService.saveAccount(account);
    }

    @Test
    public void queryAll() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContest.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.queryAccountList();
        accounts.forEach(System.out::println);
    }

}
