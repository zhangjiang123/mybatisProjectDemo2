package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class role implements Serializable {

    private Integer roleId;
    private String RoleName;
    private String RoleDesc;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        RoleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "role{" +
                "roleId=" + roleId +
                ", RoleName='" + RoleName + '\'' +
                ", RoleDesc='" + RoleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}
