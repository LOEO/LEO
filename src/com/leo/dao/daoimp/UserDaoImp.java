package com.leo.dao.daoimp;

import com.leo.dao.UserDao;
import com.leo.model.User;
import com.leo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LT on 2014/12/13.
 */
@Component
public class UserDaoImp implements UserDao {
    private HibernateUtil hibernateUtil;

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>)hibernateUtil.find("select new User(id,username,nickname,age,birthday,sex,avatar,email,phone) from User");
        //List<User> users = (List<User>)hibernateUtil.find("select new User(id,username,nickname,age,birthday) from User");
        return users;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public User find(String username) {
        return hibernateUtil.findUnique("from User u where u.username = ?",username);
    }

    @Override
    public void addUser(User user) {
        hibernateUtil.save(user);
    }

    @Override
    public void updateUser(User user) {
        hibernateUtil.save(user);
    }

    @Override
    public void delUser(User user) {
        hibernateUtil.remove(user);
    }

    @Override
    public void delUser(int id) {
        hibernateUtil.removeById(User.class,id);
    }


    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
