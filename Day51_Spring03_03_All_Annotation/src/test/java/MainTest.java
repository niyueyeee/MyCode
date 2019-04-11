import com.itheima.config.SpringConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author niyueyeee
 * @create 2019-04-03 22:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MainTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void test() {
        accountService.queryAccountList();
    }
}
