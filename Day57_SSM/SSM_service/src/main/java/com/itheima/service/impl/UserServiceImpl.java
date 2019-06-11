package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.pojo.Role;
import com.itheima.pojo.SysUser;
import com.itheima.service.UserService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-17 17:30
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDao userDao;

    /**
     * 通过用户名载入用户对象
     * 思路：
     * 根据用户名从数据获取用户对象（SysUser）
     * 创建UserDetails（User）用户详情对象返回
     *
     * @param usr
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String usr) throws UsernameNotFoundException {
        SysUser sysUser = userDao.findByUserName(usr);
        if (sysUser != null) {
            //创建角色列表对象
            List<GrantedAuthority> list = new ArrayList<>();
            //创建角色对象
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            //从数据库查询
            for (Role role : sysUser.getRoleList()) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
                //添加角色对象
                list.add(simpleGrantedAuthority);
            }
            /**
             * 参数1：用户名
             * 参数2：密码
             * 参数3：角色列表
             */
            User user = new User(sysUser.getUsername(), sysUser.getPassword(), list);
            return user;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(SysUser user) {
        String password = user.getPassword();
        //String md5 = MD5Utils.md5(password);
        String md5 = bCryptPasswordEncoder.encode(password);
        user.setPassword(md5);
        userDao.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        SysUser sysUser = userDao.checkUsername(username);
        return sysUser == null;
    }

    @Override
    public SysUser findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void addRolesToUser(Integer userId, Integer[] ids) {
        //1. 删除该用户已有的角色
        userDao.delRolesFromUser(userId);
        //2, 维护新的关系
        if (ids != null) {
            for (Integer id : ids) {
                userDao.addRoleToUser(userId, id);
            }
        }
    }
}
