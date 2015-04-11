package com.leo.service;

import com.leo.dao.UserDao;
import com.leo.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/20.
 */
public interface UserService {
    public List<User> getAllUser();
    public Map<String,Object> getPagingUser(int pageNo,int pageSize);
    public User findUserById(int id);
    public User findUserByUsername(String username);
    public void addUser(User user);
    public String addUser(Map<String,String> formData);
    public void updateUser(User user);
    public void delUser(User user);
    public void delUser(int id);
    public boolean exist(String name);
    public User userLogin(String username,String password);
    public String userRegister(Map<String,String> map);
    public User updateUser(Map<String,String> map);
    public User uploadAvatar(String username,String avatar,String path,String filename);
}
