package cn.itcast;

import cn.itcast.pojo.User;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-02 14:12
 */
public class JPQLTest {
    @Test
    public void test1(){
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        //使用工厂创建 entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //根据用户名和密码查询
        Query query = entityManager.createQuery("from User where username=?2 and password=?1");
        query.setParameter(2,"xiaohong");
        query.setParameter(1,"123");

        User user = (User) query.getSingleResult();
        System.out.println(user);

        //释放资源
        entityManager.close();
    }
    @Test
    public void test2(){
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        //使用工厂创建 entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //根据用户名和密码查询
        Query query = entityManager.createQuery("from User Order by age desc");

        List<User> users = query.getResultList();
        users.forEach(System.out::println);
        users.forEach(u-> System.out.println(u));


        //释放资源
        entityManager.close();
    }
    @Test
    public void test3(){
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        //使用工厂创建 entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //根据用户名和密码查询
        Query query = entityManager.createQuery("from User order by age desc");
        //设置起始索引
        query.setFirstResult(0);
        query.setMaxResults(2);

        List<User> users = query.getResultList();
        users.forEach(System.out::println);
        //释放资源
        entityManager.close();
    }
    @Test
    public void test4(){
        //创建 entityManager工厂对象 类比mybatis中 创建 sqlSessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        //使用工厂创建 entityManager 类比mybatis中 sqlSessionFactory创建 sqlSession 底层就是连接
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //根据用户名和密码查询
        Query query = entityManager.createNativeQuery("delete from user where uid=?");
        query.setParameter(1,1);

        query.executeUpdate();
        transaction.commit();

        //释放资源
        entityManager.close();
    }
}
