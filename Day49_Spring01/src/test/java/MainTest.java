import com.itheima.pojo.Account;
import com.itheima.pojo.FuZaDemo;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author niyueyeee
 * @create 2019-03-31 20:54
 */
public class MainTest {
    @Test
    public void springIoc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService bean = applicationContext.getBean(AccountService.class);
        System.out.println(bean);
    }

    @Test
    public void testScope() {
        //  ClassPathXmlApplicationContext  专门读取xml的容器对象
        //  容器对象 会把 配置文件读取完毕  然后将 对象 存储到容器中
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);
        AccountService accountService2 = context.getBean("accountService", AccountService.class);

        System.out.println(accountService);
        System.out.println(accountService2);
    }

    @Test
    public void testLife() {
        //  ClassPathXmlApplicationContext  专门读取xml的容器对象
        //  容器对象 会把 配置文件读取完毕  然后将 对象 存储到容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);


        System.out.println(accountService);

        //关闭容器
        context.close();

    }

    @Test
    public void testDIJianDanShuJu() {
        //  ClassPathXmlApplicationContext  专门读取xml的容器对象
        //  容器对象 会把 配置文件读取完毕  然后将 对象 存储到容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Account account = context.getBean("account", Account.class);

        System.out.println("------------");

    }


    @Test
    public void testDIFuZaShuJu() {
        //  ClassPathXmlApplicationContext  专门读取xml的容器对象
        //  容器对象 会把 配置文件读取完毕  然后将 对象 存储到容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        FuZaDemo fuZaDemo = context.getBean("fuZaDemo", FuZaDemo.class);

        System.out.println("------------");

    }

    @Test
    public void testFactory() {
        //  ClassPathXmlApplicationContext  专门读取xml的容器对象
        //  容器对象 会把 配置文件读取完毕  然后将 对象 存储到容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext02.xml");
        Account account = context.getBean("account", Account.class);

        System.out.println(account);

    }


}
