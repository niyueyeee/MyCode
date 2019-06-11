package com.itheima.service;

import com.itheima.pojo.Permission;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 10:37
 */
public interface PermissionService {
    List<Permission> findAll();

    /**
     * @return
     */
    List<Permission> findParentPermission();

    void save(Permission permission);
}
