import com.itheima.factory.ProxyFactory;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author niyueyeee
 * @create 2019-04-03 21:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProxyTest {
    @Autowired
    @Qualifier("accountServiceImplNoTCF")
    private AccountService accountServiceNoTCF;

    @Autowired
    @Qualifier("proxyFactory")
    private ProxyFactory proxyFactory;

    @Test
    public void test() throws Exception {
        AccountService proxy = (AccountService) proxyFactory.createProxy(accountServiceNoTCF);
        proxy.transfer("ls","zs",20000f);
    }
}
