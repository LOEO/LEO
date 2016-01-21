package com.leo.model;

import javax.persistence.*;

/**
 * Created by LT on 2015/12/28 0028 22:37
 */
@Entity
@Table(name = "t_sys_button", schema = "leo", catalog = "")
public class SysButton {
    private int id;
    private String name;
    private String clazz;
    private String icon;
    private String script;
    private int menuId;
    private int ord;
    private String status;

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
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "script")
    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Basic
    @Column(name = "menuId")
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "ord")
    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysButton sysButton = (SysButton) o;

        if (id != sysButton.id) return false;
        if (menuId != sysButton.menuId) return false;
        if (ord != sysButton.ord) return false;
        if (name != null ? !name.equals(sysButton.name) : sysButton.name != null) return false;
        if (clazz != null ? !clazz.equals(sysButton.clazz) : sysButton.clazz != null) return false;
        if (icon != null ? !icon.equals(sysButton.icon) : sysButton.icon != null) return false;
        if (script != null ? !script.equals(sysButton.script) : sysButton.script != null) return false;
        if (status != null ? !status.equals(sysButton.status) : sysButton.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (script != null ? script.hashCode() : 0);
        result = 31 * result + menuId;
        result = 31 * result + ord;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
