package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-02 14:44
 *
 * 以查询为例规则
 *  find|read|get|query|stream +"By" +属性名+[查询规则]
 *
 *
 *  delete|remove  删除
 *
 *
 *  exists 判断是否存在
 *
 *  count  计数
 *
 *
 *      关键字+By+javaBean属性名+[查询规则]+And|Or+javaBean属性名+[查询规则]+And|Or........
 *
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    @Query(value = "select * from user where username=? and password=?",nativeQuery =true )
    User findByUsernameAndPassword2(String username,String password);

    @Query(value = "select * from user where username=:username and password=:password",nativeQuery =true )
    User findByUsernameAndPassword3(@Param("username") String x, @Param("password") String y);

    @Query(value = "DELETE from user where username=? ",nativeQuery =true )
    @Modifying
    void deleteByUsername(String username);



    User findByUsername(String username);
    User readByUsername(String username);
    User getByUsername(String username);
    User queryByUsername(String username);
    User streamByUsername(String username);


    User findByUsernameIs(String username);

    User findByUsernameEquals(String username);


    List<User> findByUsernameLike(String username);
    List<User> findByUsernameNotLike(String username);


    List<User> findByAgeBetween(int start,int end);

    List<User> findByAgeLessThan(int age);

    List<User> findByAgeLessThanEqual(int age);

    List<User> findByAgeGreaterThan(int age);

    List<User> findByAgeGreaterThanEqual(int age);

    List<User> findByAgeAfter(int age);
    List<User> findByAgeBefore(int age);

    List<User> findByUsernameIsNull();

    List<User> findByUsernameNotNull();

    List<User> findByUsernameStartingWith(String username);

    List<User> findByUsernameEndingWith(String username);

    List<User> findByUsernameContaining(String username);



    List<User> findByAgeNot(int age);

    List<User> findByAgeIn(List<Integer> ids);

    List<User> findByAgeNotIn(List<Integer> ids);

    List<User> findByVipTrue();

    List<User> findByVipFalse();

    List<User> findByUsernameIgnoreCase(String username);



    List<User> findByUsernameOrderByAgeDesc(String username);


    int removeByUsername(String username);

    boolean existsByUsername(String username);

    long countByUsername(String username);


    User findByUsernameAndPassword(String username,String password);

    List<User> findByUsernameOrPassword(String username,String password);
}
