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
@Table(name = "t_user", schema = "", catalog = "leo")
public class User {
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
    private Org tOrgByOrgId;
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;

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
    public Org gettOrgByOrgId() {
        return tOrgByOrgId;
    }

    public void settOrgByOrgId(Org tOrgByOrgId) {
        this.tOrgByOrgId = tOrgByOrgId;
    }
}
