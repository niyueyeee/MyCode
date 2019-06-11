package com.itheima.controller;

import com.itheima.pojo.Permission;
import com.itheima.pojo.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jnlp.PersistenceService;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 9:54
 */
@Controller
@RequestMapping("/role")
@Secured("ROLE_ADMIN")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    @Autowired
    PermissionService permissionService;

    /**
     * 添加权限到角色的数据回显
     *
     * @param id
     * @return
     */
    @RequestMapping("/addPermissionsToRoleUI")
    public ModelAndView addPermissionsToRoleUI(Integer id) {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //1. 所有的角色
        List<Permission> permissionList = permissionService.findAll();
        //2. 已有的角色
        Role role = roleService.findById(id);
        StringBuffer buffer = new StringBuffer();
        for (Permission permission : role.getPermissionList()) {
            buffer.append(",");
            buffer.append(permission.getId());
            buffer.append(",");
        }
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("str", buffer.toString());
        modelAndView.addObject("roleId", role.getId());
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 添加权限到角色
     *
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermissionsToRole")
    public String addPermissionsToRole(Integer roleId, Integer[] ids) {
        System.out.println(roleId);
        roleService.addPermissionsToRole(roleId, ids);
        return "redirect:/role/findAll";
    }
}
