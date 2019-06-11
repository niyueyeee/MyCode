package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.pojo.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 10:07
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.finaById(id);
    }

    @Override
    public void addPermissionsToRole(Integer roleId, Integer[] ids) {
        //1. 删除该角色已有的权限
        roleDao.delPermissionsFromRole(roleId);
        //2. 维护新的关系
        if (ids != null) {
            for (Integer id : ids) {
                roleDao.addPermissionsFromRole(roleId, id);
            }
        }
    }
}
