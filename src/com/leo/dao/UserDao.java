package com.leo.dao;

import com.leo.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/13.
 */
public interface UserDao {
    public List<User> findAll();
    public Map<String,Object> findByPaging(int pageNo,int pageSize);
    public User find(int id);
    public User find(String username);
    public void addUser(User user);
    public void updateUser(User user);
    public void delUser(User user);
    public void delUser(int id);
}
