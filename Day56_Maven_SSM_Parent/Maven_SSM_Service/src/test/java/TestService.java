import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author niyueyeee
 * @create 2019-04-12 19:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/*"})
public class TestService {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = userService.findById(2);
        System.out.println(user.getName());

    }
}
