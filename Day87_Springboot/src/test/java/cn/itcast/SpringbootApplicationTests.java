package cn.itcast;

import cn.itcast.dao.UserDao;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userDao.findById(1).get());
    }

    @Test
    public void update() {
        userService.update();
    }
}
