package com.leo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LT on 2015/12/28 0028 22:37
 */
@Entity
@Table(name = "t_menu", schema = "leo", catalog = "")
public class Menu {
    private int id;
    private String name;
    private String icon;
    private String url;
    private Integer pid;
    private Byte isVisible;
    private Byte isLeaf;
    private Integer ord;
    private Set<Button> buttons = new HashSet<Button>();

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
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "isVisible")
    public Byte getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Byte isVisible) {
        this.isVisible = isVisible;
    }

    @Basic
    @Column(name = "isLeaf")
    public Byte getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Byte isLeaf) {
        this.isLeaf = isLeaf;
    }

    @Basic
    @Column(name = "ord")
    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @OneToMany
    @JoinColumn(name = "menuId",referencedColumnName = "id")
    public Set<Button> getButtons() {
        return buttons;
    }

    public void setButtons(Set<Button> buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (name != null ? !name.equals(menu.name) : menu.name != null) return false;
        if (icon != null ? !icon.equals(menu.icon) : menu.icon != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        if (pid != null ? !pid.equals(menu.pid) : menu.pid != null) return false;
        if (isVisible != null ? !isVisible.equals(menu.isVisible) : menu.isVisible != null) return false;
        if (isLeaf != null ? !isLeaf.equals(menu.isLeaf) : menu.isLeaf != null) return false;
        if (ord != null ? !ord.equals(menu.ord) : menu.ord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (isVisible != null ? isVisible.hashCode() : 0);
        result = 31 * result + (isLeaf != null ? isLeaf.hashCode() : 0);
        result = 31 * result + (ord != null ? ord.hashCode() : 0);
        return result;
    }
}
