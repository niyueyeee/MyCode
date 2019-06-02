package cn.itcast;

import cn.itcast.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NiYueYeee
 * @create 2019-06-02 14:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class JPQLTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testFindByUsername1(){
        System.out.println(userDao.findByUsername("xiaohong"));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFindByUsername2(){
        System.out.println(userDao.findByUsernameAndPassword("xiaohong","123"));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFindByUsername3(){
        System.out.println(userDao.findByUsernameAndPassword2("xiaohong","123"));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFindByUsername4(){
        System.out.println(userDao.findByUsernameAndPassword3("xiaohong","123"));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFindByUsername5(){
        userDao.deleteByUsername("xiaohong");
    }
}
