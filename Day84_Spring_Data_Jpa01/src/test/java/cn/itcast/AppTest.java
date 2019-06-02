package cn.itcast;

import cn.itcast.pojo.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author NiYueYeee
 * @create 2019-06-02 13:46
 */
public class AppTest {
    //保存
    @Test
    public void testSave() {
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        // entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User("苏明月", "123", 28);
        entityManager.persist(user);
        //提交事务
        transaction.commit();
        //释放资源
        entityManager.close();
    }
    //更新
    @Test
    public void testUpdate() {
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        // entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User("苏明月yue", "123", 28);
        user.setId(1);
        entityManager.merge(user);
        //提交事务
        transaction.commit();
        //释放资源
        entityManager.close();
    }
    //查询
    @Test
    public void testFind1() {
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        // entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.find(User.class, 1));
        //释放资源
        entityManager.close();
    }
    //查询  懒加载
    @Test
    public void testFind2() {
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        // entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getReference(User.class, 1).getUsername());
        //释放资源
        entityManager.close();
    }
    //删除
    @Test
    public void testRemove() {
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        // entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, 1);
        entityManager.remove(user);
        //提交事务
        transaction.commit();
        //释放资源
        entityManager.close();
    }
}
