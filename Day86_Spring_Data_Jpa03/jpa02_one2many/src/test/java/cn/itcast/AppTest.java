package cn.itcast;

import cn.itcast.dao.ReceivingAddressDao;
import cn.itcast.dao.UserDao;
import cn.itcast.pojo.ReceivingAddress;
import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-03 21:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReceivingAddressDao receivingAddressDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave1() {
        //现在假设 认为 这两个啥关系没有

        User user = new User("小户", "123", 31);

        ReceivingAddress receivingAddress = new ReceivingAddress("xxx小区xxx楼xx单元...", "455000", "137xxxxxxxxx");

        //创建数据的关联关系
        user.getReceivingAddressList().add(receivingAddress);

        receivingAddress.setUser(user);

        receivingAddressDao.save(receivingAddress);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave2() {
        //现在假设 认为 这两个啥关系没有

        User user = new User("小户", "123", 31);

        ReceivingAddress receivingAddress = new ReceivingAddress("xxx小区xxx楼xx单元...", "455000", "137xxxxxxxxx");


        //创建数据的关联关系
        user.getReceivingAddressList().add(receivingAddress);


        userDao.save(user);

        //表达意愿 保存用户的时候 发现数据关联关系 顺便关联关系的数据 操作一下  级联操作


    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave3() {
        //现在假设 认为 这两个啥关系没有

        //User user = new User("小户", "123", 31);
        User user = userDao.findById(1).get();

        ReceivingAddress receivingAddress1 = new ReceivingAddress("xxx小区xxx楼xx单元...", "455000", "137xxxxxxxxx");
        ReceivingAddress receivingAddress2 = new ReceivingAddress("北京市昌平区........", "100000", "137xxxxxxxxx");

        receivingAddress1.setUser(user);
        receivingAddress2.setUser(user);

        receivingAddressDao.save(receivingAddress1);
        receivingAddressDao.save(receivingAddress2);


    }


    @Test
    @Transactional
    @Rollback(false)
    public void testDelete4() {
        User user = userDao.findById(1).get();
        userDao.delete(user);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void testFind1() {
        //这种方式 对象导航查询
        User user = userDao.findById(1).get();
        System.out.println(user);

        List<ReceivingAddress> receivingAddressList = user.getReceivingAddressList();
        receivingAddressList.forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind2() {
        //这种方式 对象导航查询

        ReceivingAddress receivingAddress = receivingAddressDao.findById(1).get();
        System.out.println(receivingAddress);
    }
}
