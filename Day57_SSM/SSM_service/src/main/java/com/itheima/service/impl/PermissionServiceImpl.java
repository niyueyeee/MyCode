package com.itheima.service.impl;

import com.itheima.dao.PermissionDao;
import com.itheima.pojo.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 10:37
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findParentPermission() {
        return permissionDao.findParentPermission();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
