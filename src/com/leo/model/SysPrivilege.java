package com.leo.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LT on 2015/11/4 0004.
 */
@Entity
@Table(name = "t_sys_privilege", schema = "", catalog = "leo")
public class SysPrivilege {
    private int id;
    private String master;
    private String masterValue;
    private String access;
    private String accessValue;
    private String operation;
    private Integer createUserId;
    private Timestamp createDate;
    private Integer modifyUserId;
    private Timestamp modifyDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "master")
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Basic
    @Column(name = "masterValue")
    public String getMasterValue() {
        return masterValue;
    }

    public void setMasterValue(String masterValue) {
        this.masterValue = masterValue;
    }

    @Basic
    @Column(name = "access")
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Basic
    @Column(name = "accessValue")
    public String getAccessValue() {
        return accessValue;
    }

    public void setAccessValue(String accessValue) {
        this.accessValue = accessValue;
    }

    @Basic
    @Column(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "createUserId")
    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "createDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modifyUserId")
    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    @Basic
    @Column(name = "modifyDate")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysPrivilege sysPrivilege = (SysPrivilege) o;

        if (id != sysPrivilege.id) return false;
        if (master != null ? !master.equals(sysPrivilege.master) : sysPrivilege.master != null) return false;
        if (masterValue != null ? !masterValue.equals(sysPrivilege.masterValue) : sysPrivilege.masterValue != null)
            return false;
        if (access != null ? !access.equals(sysPrivilege.access) : sysPrivilege.access != null) return false;
        if (accessValue != null ? !accessValue.equals(sysPrivilege.accessValue) : sysPrivilege.accessValue != null)
            return false;
        if (operation != null ? !operation.equals(sysPrivilege.operation) : sysPrivilege.operation != null) return false;
        if (createUserId != null ? !createUserId.equals(sysPrivilege.createUserId) : sysPrivilege.createUserId != null)
            return false;
        if (createDate != null ? !createDate.equals(sysPrivilege.createDate) : sysPrivilege.createDate != null) return false;
        if (modifyUserId != null ? !modifyUserId.equals(sysPrivilege.modifyUserId) : sysPrivilege.modifyUserId != null)
            return false;
        if (modifyDate != null ? !modifyDate.equals(sysPrivilege.modifyDate) : sysPrivilege.modifyDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (master != null ? master.hashCode() : 0);
        result = 31 * result + (masterValue != null ? masterValue.hashCode() : 0);
        result = 31 * result + (access != null ? access.hashCode() : 0);
        result = 31 * result + (accessValue != null ? accessValue.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyUserId != null ? modifyUserId.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        return result;
    }
}
