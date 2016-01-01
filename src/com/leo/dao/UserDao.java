package com.leo.dao;

import com.leo.model.User;
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

    public List<User> findAll() {
        List<User> users = (List<User>)hibernateUtil.find("select new User(id,username,nickname,age,birthday,sex,avatar,email,phone) from User");
        return users;
    }

    public Map<String,Object> findByPaging(int start, int limit,String[] property,Object[] values) {
        return hibernateUtil.findByPaging(User.class,start,limit,property,values);
    }


    public User find(int id) {
        return null;
    }

    public User find(String username) {
        return hibernateUtil.findUnique("from User u where u.username = ?",username);
    }

    public void addUser(User user) {
        hibernateUtil.save(user);
    }

    public void updateUser(User user) {
        hibernateUtil.save(user);
    }

    public void delUser(User user) {
        hibernateUtil.remove(user);
    }

    public void delUser(int id) {
        hibernateUtil.removeById(User.class,id);
    }

    public List<User> findUserByProperty(String[] property,Object[] values) {
        return hibernateUtil.findByProperty(User.class, property, values);
    }


    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
