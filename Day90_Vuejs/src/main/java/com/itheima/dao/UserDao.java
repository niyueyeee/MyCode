package com.itheima.dao;

import com.itheima.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author NiYueYeee
 * @create 2019-06-09 18:10
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
