import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author niyueyeee
 * @create 2019-04-12 19:58
 */
public class TestDao {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao.findById(1));
    }
}
