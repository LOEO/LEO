package com.leo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LT on 2015/11/4 0004.
 */
@Entity
@Table(name = "t_role", schema = "", catalog = "leo")
public class Role {
    private int id;
    private String name;
    private String descp;
    private Set<User> users = new HashSet<User>();

    @ManyToMany()
    @JoinTable(name = "t_user_role",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns ={@JoinColumn(name="userId")} )
    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descp")
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

        Role role = (Role) o;

        if (id != role.id) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (descp != null ? !descp.equals(role.descp) : role.descp != null) return false;

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
