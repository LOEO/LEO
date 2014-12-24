package com.leo.model;

import javax.persistence.*;

/**
 * Created by LT on 2014/12/13.
 */
@Entity
@Table(name = "t_org", schema = "", catalog = "leo")
public class Org {
    private int id;
    private String name;
    private Integer pid;
    private String descp;

    @Id
    @Column(name = "id")
    @GeneratedValue
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
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

        Org org = (Org) o;

        if (id != org.id) return false;
        if (descp != null ? !descp.equals(org.descp) : org.descp != null) return false;
        if (name != null ? !name.equals(org.name) : org.name != null) return false;
        if (pid != null ? !pid.equals(org.pid) : org.pid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (descp != null ? descp.hashCode() : 0);
        return result;
    }
}
