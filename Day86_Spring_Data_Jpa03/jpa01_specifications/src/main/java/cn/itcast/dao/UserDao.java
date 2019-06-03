package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author NiYueYeee
 * @create 2019-06-03 20:09
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
