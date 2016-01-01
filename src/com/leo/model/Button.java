package com.leo.model;

import javax.persistence.*;

/**
 * Created by LT on 2015/12/28 0028 22:37
 */
@Entity
@Table(name = "t_button", schema = "leo", catalog = "")
public class Button {
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

        Button button = (Button) o;

        if (id != button.id) return false;
        if (menuId != button.menuId) return false;
        if (ord != button.ord) return false;
        if (name != null ? !name.equals(button.name) : button.name != null) return false;
        if (clazz != null ? !clazz.equals(button.clazz) : button.clazz != null) return false;
        if (icon != null ? !icon.equals(button.icon) : button.icon != null) return false;
        if (script != null ? !script.equals(button.script) : button.script != null) return false;
        if (status != null ? !status.equals(button.status) : button.status != null) return false;

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
