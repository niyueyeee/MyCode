import com.itheima.config.SpringConfig;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 22:52
 */
public class MainTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.queryAccountList();
        accounts.forEach(System.out::println);

    }
}
