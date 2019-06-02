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

import java.util.ArrayList;
import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-02 15:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class MethodTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testQueryOne(){
        User user1 = userDao.findByUsername("小亮");
        System.out.println(user1);
        User user2 = userDao.readByUsername("小亮");
        System.out.println(user2);
        User user3 = userDao.queryByUsername("小亮");
        System.out.println(user3);
        User user4 = userDao.streamByUsername("小亮");
        System.out.println(user4);
        User user5 = userDao.getByUsername("小亮");
        System.out.println(user5);
    }

    @Test
    /**
     * 等于规则查询
     */
    public void testQueryIsAndEquals(){
        User user1 = userDao.findByUsername("小亮");
        System.out.println(user1);
        User user2 = userDao.findByUsernameIs("小亮");
        System.out.println(user2);
        User user3 = userDao.findByUsernameEquals("小亮");
        System.out.println(user3);
    }
    @Test
    /**
     * like规则查询
     */
    public void testQueryLike(){
        List<User> users1 = userDao.findByUsernameLike("%小%");
        users1.forEach(u-> System.out.println(u));
        List<User> users2 = userDao.findByUsernameNotLike("小胡");
        users2.forEach(u-> System.out.println(u));
    }
    @Test
    /**
     * 测试区间访问 > >= < <=
     */
    public void testCalc(){
        List<User> users=null;
        users=userDao.findByAgeBetween(1,20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeLessThan(20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeLessThanEqual(20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeGreaterThan(20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeGreaterThanEqual(20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeAfter(20);
        users.forEach(u-> System.out.println(u));

        users=userDao.findByAgeBefore(20);
        users.forEach(u-> System.out.println(u));
    }
    @Test
    public void testNull(){
        List<User> users1 = userDao.findByUsernameIsNull();
        users1.forEach(u-> System.out.println(u));
        List<User> users2 = userDao.findByUsernameNotNull();
        users2.forEach(u-> System.out.println(u));
    }

    @Test
    /**
     * 测试包含关系
     */
    public void testStartEndContain(){
        List<User> users1 = userDao.findByUsernameStartingWith("小");
        users1.forEach(u-> System.out.println(u));
        List<User> users2 = userDao.findByUsernameEndingWith("亮");
        users2.forEach(u-> System.out.println(u));
        List<User> users3 = userDao.findByUsernameContaining("亮");
        users3.forEach(u-> System.out.println(u));
    }

    @Test
    /**
     * 测试 in语句
     */
    public void testNotIn(){
        List<User> users1 = userDao.findByAgeNot(20);
        users1.forEach(u-> System.out.println(u));
        List<Integer> ids = new ArrayList<>();
        ids.add(18);
        ids.add(11);
        List<User> users2 = userDao.findByAgeIn(ids);
        users2.forEach(u-> System.out.println(u));
        List<User> users3 = userDao.findByAgeNotIn(ids);
        users3.forEach(u-> System.out.println(u));
    }
    @Test
    /**
     * 测试bool判断
     */
    public void testBool() {
        List<User> users1 = userDao.findByVipTrue();
        users1.forEach(u -> System.out.println(u));
        List<User> users2 = userDao.findByVipFalse();
        users2.forEach(u -> System.out.println(u));

    }
    @Test
    public void testIgnoreCase() {
        List<User> users1 = userDao.findByUsernameIgnoreCase("小明X");
        users1.forEach(u -> System.out.println(u));
    }
    @Test
    public void testOrderBy() {
        List<User> users1 = userDao.findByUsernameOrderByAgeDesc("小明");
        users1.forEach(u -> System.out.println(u));
    }
    @Test
    @Transactional(readOnly = false)
    @Rollback(false)
    public void testDelete() {
        int i = userDao.removeByUsername("测试删除");

        System.out.println(i);

    }

    @Test
    public void testExist() {
        boolean b = userDao.existsByUsername("小明");
        System.out.println(b);

    }
    @Test
    public void testCount() {
        long b = userDao.countByUsername("小明");
        System.out.println(b);

    }

    @Test
    public void testMultiple1() {
        User user = userDao.findByUsernameAndPassword("小明", "123");
        System.out.println(user);

    }
    @Test
    public void testMultiple2() {
        List<User> userList = userDao.findByUsernameOrPassword("小明", "123");
        for (User user : userList) {
            System.out.println(user);
        }


    }
}
