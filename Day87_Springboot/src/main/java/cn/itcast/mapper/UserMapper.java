package cn.itcast.mapper;

import cn.itcast.pojo.User;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-04 21:10
 */
public interface UserMapper {
    List<User> findAll();
}
