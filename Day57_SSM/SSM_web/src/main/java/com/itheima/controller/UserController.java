package com.itheima.controller;

import com.itheima.dao.UserDao;
import com.itheima.pojo.Role;
import com.itheima.pojo.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-18 20:41
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<SysUser> userList = userService.findAll();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String save(SysUser user) {
        userService.save(user);
        return "redirect:/user/findAll";
    }

    /**
     * 验证唯一用户名
     *
     * @param username
     * @return
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(String username) {
        boolean isUnique = userService.checkUsername(username);
        return String.valueOf(isUnique);
    }

    /**
     * 查询用户详情
     *
     * @return
     */
    @RequestMapping("/details")
    public ModelAndView details(Integer id) {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据 -- 查询用户
        SysUser user = userService.findById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @Autowired
    RoleService roleService;

    /**
     * 添加角色到用户的数据回显操作
     *
     * @param id
     * @return
     */
    @RequestMapping("/addRolesToUserUI")
    public ModelAndView addRolesToUserUI(Integer id) {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //1. 所有的角色
        List<Role> roleList = roleService.findAll();
        //2. 已有的角色
        SysUser user = userService.findById(id);
        StringBuffer buffer = new StringBuffer();
        for (Role role : user.getRoleList()) {
            buffer.append(",");
            buffer.append(role.getId());
            buffer.append(",");
        }
        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("str", buffer.toString());
        modelAndView.addObject("userId", user.getId());
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 添加角色到用户
     *
     * @param userId
     * @param ids
     * @return
     */
    @RequestMapping("/addRolesToUser")
    public String addRolesToUser(Integer userId, Integer[] ids) {
        userService.addRolesToUser(userId, ids);
        return "redirect:/user/findAll";
    }
}
