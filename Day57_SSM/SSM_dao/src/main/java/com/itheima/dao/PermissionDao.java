package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 10:38
 */
public interface PermissionDao {
    List<Permission> findAll();

    List<Permission> findParentPermission();

    void save(Permission permission);

    List<Permission> findPermissionListByRoleId(Integer integer);
}
