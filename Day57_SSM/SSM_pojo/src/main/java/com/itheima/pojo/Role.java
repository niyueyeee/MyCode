package com.itheima.pojo;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-19 9:52
 */
public class Role {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<SysUser> sysUserList;
    private List<Permission> permissionList;

    public Integer getId() {
        return id;
    }

    public List<SysUser> getSysUserList() {
        return sysUserList;
    }

    public void setSysUserList(List<SysUser> sysUserList) {
        this.sysUserList = sysUserList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
