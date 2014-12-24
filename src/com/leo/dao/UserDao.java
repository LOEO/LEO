package com.leo.dao;

import com.leo.model.User;

import java.util.List;

/**
 * Created by LT on 2014/12/13.
 */
public interface UserDao {
    public List<User> findAll();
    public User find(int id);
    public User find(String username);
    public void addUser(User user);
    public void updateUser(User user);
    public void delUser(User user);
    public void delUser(int id);
}
