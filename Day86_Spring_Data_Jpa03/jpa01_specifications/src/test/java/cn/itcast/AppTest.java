package cn.itcast;

import cn.itcast.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;

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
}
