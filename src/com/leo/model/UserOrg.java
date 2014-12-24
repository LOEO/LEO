package com.leo.model;

import javax.persistence.*;

/**
 * Created by LT on 2014/12/13.
 */
@Entity
@Table(name = "t_user_org", schema = "", catalog = "leo")
public class UserOrg {
    private int id;
    private User userByUserId;
    private Org orgByOrgId;

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

        UserOrg userOrg = (UserOrg) o;

        if (id != userOrg.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "orgId", referencedColumnName = "id")
    public Org getOrgByOrgId() {
        return orgByOrgId;
    }

    public void setOrgByOrgId(Org orgByOrgId) {
        this.orgByOrgId = orgByOrgId;
    }
}
