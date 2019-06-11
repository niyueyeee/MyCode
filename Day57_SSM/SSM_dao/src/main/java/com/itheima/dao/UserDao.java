package com.itheima.dao;

import com.itheima.pojo.SysUser;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-17 17:45
 */
public interface UserDao {
    SysUser findByUserName(String usr);

    /**
     * 查询所有
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
    SysUser checkUsername(String username);

    /**
     * 查询用户的详情
     *
     * @param id
     * @return
     */
    SysUser findById(Integer id);

    /**
     * 删除已有的角色
     *
     * @param userId
     */
    void delRolesFromUser(Integer userId);

    /**
     * 维护新的关系
     *
     * @param id
     */
    void addRoleToUser(Integer userId, Integer id);
}
