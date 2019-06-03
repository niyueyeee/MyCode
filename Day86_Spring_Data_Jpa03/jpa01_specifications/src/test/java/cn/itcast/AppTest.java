package cn.itcast;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-03 20:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testFind1() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root 代表操作实体的属性集合
                //CriteriaQuery 不管他
                //CriteriaBuilder 标准条件构建器  提供很多的方法 可以帮助你构建Predicate
                Path username = root.get("username");
                Predicate predicate = criteriaBuilder.equal(username, "小明");

                return predicate;
            }
        };
        System.out.println(userDao.findOne(spe).get());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind2() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root 代表操作实体的属性集合
                //CriteriaQuery 不管他
                //CriteriaBuilder 标准条件构建器  提供很多的方法 可以帮助你构建Predicate
                Path age = root.get("age");
                Predicate predicate = criteriaBuilder.gt(age, 30);

                return predicate;
            }
        };
        userDao.findAll(spe).forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind3() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root 代表操作实体的属性集合
                //CriteriaQuery 不管他
                //CriteriaBuilder 标准条件构建器  提供很多的方法 可以帮助你构建Predicate
                Path username = root.get("username");
                Predicate predicate2 = criteriaBuilder.equal(username, "小明");
                //获取password属性
                Path password = root.get("password");
                Predicate predicate1 = criteriaBuilder.equal(password, 123);
                Predicate and = criteriaBuilder.and(predicate1, predicate2);
                Predicate or = criteriaBuilder.or(predicate1, predicate2);
                return and;
            }
        };
        userDao.findAll(spe).forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind4() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root 代表操作实体的属性集合
                //CriteriaQuery 不管他
                //CriteriaBuilder 标准条件构建器  提供很多的方法 可以帮助你构建Predicate
                Path<Integer> age = root.get("age");
                Predicate predicate = criteriaBuilder.gt(age, 0);
                criteriaQuery.groupBy(root.get("age")).having(predicate);

                return null;
            }
        };
        userDao.findAll(spe).forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind5() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path age = root.get("age");
                Predicate predicate = criteriaBuilder.gt(age, 10);
                return predicate;
            }
        };
        Sort sort1 = new Sort(Sort.Direction.DESC, "age");
        Sort sort2 = new Sort(Sort.Direction.ASC, "id");
        Sort sort = sort1.and(sort2);
        userDao.findAll(spe, sort).forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind6() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path age = root.get("age");
                Predicate predicate = criteriaBuilder.gt(age, 10);
                return predicate;
            }
        };
        Pageable pageable = PageRequest.of(1, 2);

        Page page = userDao.findAll(spe, pageable);

        List<User> content = page.getContent();
        System.out.println("当前页的数据:");
        content.forEach(System.out::println);

        System.out.println(page.getTotalPages());

        System.out.println(page.getTotalElements());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind7() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path age = root.get("age");
                Predicate predicate = criteriaBuilder.gt(age, 10);
                return predicate;
            }
        };
        System.out.println(userDao.count(spe));
    }
}
