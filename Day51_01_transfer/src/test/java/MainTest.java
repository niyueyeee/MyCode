import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MainTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void eazyTransfer() throws Exception {
        accountService.transfer("zs", "ls", 5000f);
    }
}
