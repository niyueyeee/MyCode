import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author niyueyeee
 * @create 2019-04-03 9:32
 */
public class MainTest {
    ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }

    @Test
    public void test() {


        AccountService accountService = context
                .getBean("accountService", AccountService.class);

        accountService.saveAccount(new Account());
    }


    @Test
    public void test_component() {

        AccountDao bean = context.getBean("accountDao", AccountDao.class);

        System.out.println(bean);

        AccountService accountService = context.getBean("accountService", AccountService.class);

        System.out.println(accountService);

    }

    @Test
    public void scope() {

        AccountDao bean = context.getBean("accountDao", AccountDao.class);

        System.out.println(bean);

//        AccountDao bean2 = context.getBean("accountDao",AccountDao.class);
//
//        System.out.println(bean2);

    }

    @Test
    public void DI() {


        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.saveAccount(new Account());


    }
}
