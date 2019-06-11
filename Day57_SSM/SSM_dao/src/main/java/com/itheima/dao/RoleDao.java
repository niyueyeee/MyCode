package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 9:59
 */
public interface RoleDao {
    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 新增角色
     *
     * @param role
     */
    void save(Role role);

    /**
     * 根据id查询角色对象，包含权限信息
     *
     * @param integer
     * @return
     */
    List<Role> findRoleListByUserId(Integer integer);

    /**
     * 根据id查询角色对象，包含权限信息
     *
     * @param id
     * @return
     */
    Role finaById(Integer id);

    /**
     * 删除已有的关系
     *
     * @param userId
     */
    void delPermissionsFromRole(Integer userId);

    /**
     * 维护新的关系
     *
     * @param userId
     * @param permissionId
     */
    void addPermissionsFromRole(Integer userId, Integer permissionId);
}
