package com.itheima.mapper;

import com.itheima.pojo.Role;
import com.itheima.pojo.User;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-29 11:59
 */
public interface RoleMapper {
    List<Role> queryRoleUser();

    List<User> queryUserRole();
}
