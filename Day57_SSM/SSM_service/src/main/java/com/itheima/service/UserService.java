package com.itheima.service;

import com.itheima.pojo.SysUser;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-17 17:30
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 保存
     *
     * @param user
     * @return
     */
    void save(SysUser user);

    /**
     * 验证唯一用户名
     *
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 查询用户的详情
     *
     * @param id
     * @return
     */
    SysUser findById(Integer id);

    /**
     * 添加角色到用户
     *
     * @param userId
     * @param ids
     */
    void addRolesToUser(Integer userId, Integer[] ids);
}
