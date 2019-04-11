import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-03 9:45
 */
public class MainTest {
    ApplicationContext context;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test(){
        AccountService accountService = context
                .getBean("accountService", AccountService.class);

        List<Account> accountList = accountService.queryAccountList();

        accountList.forEach(System.out::println);
    }
}
