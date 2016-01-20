package com.leo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LT on 2015/11/4 0004.
 */
@Entity
@Table(name = "t_sys_role", schema = "", catalog = "leo")
public class SysRole {
    public interface WithoutSysUsers{}
    public interface WithSysUsers extends WithoutSysUsers{}
    private int id;
    private String name;
    private String descp;
    private Set<SysUser> sysUsers = new HashSet<SysUser>();

    @ManyToMany()
    @JoinTable(name = "t_sys_user_role",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns ={@JoinColumn(name="userId")} )
    @JsonView(WithSysUsers.class)
    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    @Id
    @Column(name = "id")
    @JsonView(WithoutSysUsers.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    @JsonView(WithoutSysUsers.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descp")
    @JsonView(WithoutSysUsers.class)
    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRole = (SysRole) o;

        if (id != sysRole.id) return false;
        if (name != null ? !name.equals(sysRole.name) : sysRole.name != null) return false;
        if (descp != null ? !descp.equals(sysRole.descp) : sysRole.descp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descp != null ? descp.hashCode() : 0);
        return result;
    }
}
