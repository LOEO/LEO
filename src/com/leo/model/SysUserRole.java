package com.leo.model;

import javax.persistence.*;

/**
 * Created by LT on 2014/12/13.
 */
@Entity
@Table(name = "t_sys_user_role", schema = "", catalog = "leo")
public class SysUserRole {
    private int id;
    private SysUser userByUserId;
    private SysRole roleByRoleId;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserRole sysUserRole = (SysUserRole) o;

        if (id != sysUserRole.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    public SysUser getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(SysUser userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    public SysRole getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(SysRole roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
