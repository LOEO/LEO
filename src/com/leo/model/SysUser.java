package com.leo.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.leo.util.DateUtil;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LT on 2015/11/4 0004.
 */
@Entity
@Table(name = "t_sys_user", schema = "", catalog = "leo")
public class SysUser {
    public interface WithoutPasswordView{}
    public interface WithPasswordView extends WithoutPasswordView{}
    private int id;
    private String username;
    private String password;
    private String nickname;
    private Integer age;
    private Date birthday;
    private String sex;
    private String avatar;
    private String email;
    private String phone;
    private SysOrg tOrgByOrgId;
    private Set<SysRole> sysRoles = new HashSet<SysRole>();

    @ManyToMany(mappedBy = "sysUsers",cascade = CascadeType.ALL)
    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Id
    @Column(name = "id")
    @JsonView(WithoutPasswordView.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname")
    @JsonView(WithoutPasswordView.class)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Transient
    @JsonView(WithoutPasswordView.class)
    public Integer getAge() {
        return DateUtil.getAgeByBirthday(birthday);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "birthday")
    @JsonView(WithoutPasswordView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    @JsonView(WithoutPasswordView.class)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "avatar")
    @JsonView(WithoutPasswordView.class)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "email")
    @JsonView(WithoutPasswordView.class)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    @JsonView(WithoutPasswordView.class)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser sysUser = (SysUser) o;

        if (id != sysUser.id) return false;
        if (username != null ? !username.equals(sysUser.username) : sysUser.username != null) return false;
        if (password != null ? !password.equals(sysUser.password) : sysUser.password != null) return false;
        if (nickname != null ? !nickname.equals(sysUser.nickname) : sysUser.nickname != null) return false;
        if (age != null ? !age.equals(sysUser.age) : sysUser.age != null) return false;
        if (birthday != null ? !birthday.equals(sysUser.birthday) : sysUser.birthday != null) return false;
        if (sex != null ? !sex.equals(sysUser.sex) : sysUser.sex != null) return false;
        if (avatar != null ? !avatar.equals(sysUser.avatar) : sysUser.avatar != null) return false;
        if (email != null ? !email.equals(sysUser.email) : sysUser.email != null) return false;
        if (phone != null ? !phone.equals(sysUser.phone) : sysUser.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orgId", referencedColumnName = "id")
    public SysOrg gettOrgByOrgId() {
        return tOrgByOrgId;
    }

    public void settOrgByOrgId(SysOrg tOrgByOrgId) {
        this.tOrgByOrgId = tOrgByOrgId;
    }
}
