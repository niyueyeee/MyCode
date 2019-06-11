package com.itheima.service;

import com.itheima.pojo.Role;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 10:07
 */
public interface RoleService {


    /**
     * 新增角色
     *
     * @param role
     */
    void save(Role role);

    /**
     * 查询所有
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 添加权限到角色的数据回显
     *
     * @param roleId
     * @return
     */
    Role findById(Integer roleId);

    /**
     * 添加权限到角色
     *
     * @param roleId
     * @param ids
     */
    void addPermissionsToRole(Integer roleId, Integer[] ids);
}
