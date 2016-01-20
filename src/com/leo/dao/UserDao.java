package com.leo.dao;

import com.leo.model.SysUser;
import com.leo.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/13.
 */
@Repository
public class UserDao {
    private HibernateUtil hibernateUtil;

    public List<SysUser> findAll() {
        List<SysUser> sysUsers = (List<SysUser>)hibernateUtil.find("select new SysUser(id,username,nickname,age,birthday,sex,avatar,email,phone) from SysUser");
        return sysUsers;
    }

    public Map<String,Object> findByPaging(int start, int limit,String[] property,Object[] values) {
        return hibernateUtil.findByPaging(SysUser.class,start,limit,property,values);
    }


    public SysUser find(int id) {
        return null;
    }

    public SysUser find(String username) {
        return hibernateUtil.findUnique("from SysUser u where u.username = ?",username);
    }

    public void addUser(SysUser sysUser) {
        hibernateUtil.save(sysUser);
    }

    public void updateUser(SysUser sysUser) {
        hibernateUtil.save(sysUser);
    }

    public void delUser(SysUser sysUser) {
        hibernateUtil.remove(sysUser);
    }

    public void delUser(int id) {
        hibernateUtil.removeById(SysUser.class,id);
    }

    public List<SysUser> findUserByProperty(String[] property,Object[] values) {
        return hibernateUtil.findByProperty(SysUser.class, property, values);
    }


    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
