package cn.itcast;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author NiYueYeee
 * @create 2019-06-02 14:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        User user = new User("赵丽颖宝贝", "123", 35);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testUpdate(){
        User user = new User("赵丽颖", "123", 35);
        user.setId(5);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind1(){
        Optional<User> byId = userDao.findById(50);
        User user = byId.orElse(new User());
        System.out.println(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind2(){
        System.out.println(userDao.getOne(5));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testRemove(){
        Optional<User> byId = userDao.findById(5);
        userDao.delete(byId.get());
    }
}
