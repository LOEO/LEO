package com.leo.service.serviceimp;

import com.leo.dao.UserDao;
import com.leo.model.User;
import com.leo.service.UserService;
import com.leo.util.Base64_Img;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/20.
 */
@Component
@Transactional
public class UserServiceImp implements UserService{
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userDao.find(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.find(username);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User updateUser(Map<String,String> map){
        User user = userDao.find(map.get("username"));
        user.setEmail(map.get("email"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(new java.sql.Date(sdf.parse(map.get("birthday")).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setAge(Integer.parseInt(map.get("age")));
        user.setSex(map.get("sex"));
        user.setPhone(map.get("phone"));
        user.setNickname(map.get("nickname"));
        userDao.updateUser(user);
        return user;
    }

    public User uploadAvatar(String username,String avatar,String path,String filename){
        avatar = avatar.replace("data:image/png;base64,","");
        if(Base64_Img.GenerateImage(avatar,path+"\\"+filename)){
            User user = userDao.find(username);
            user.setAvatar(filename);
            userDao.updateUser(user);
            return user;
        }
        return null;
    }

    @Override
    public void delUser(User user) {
        userDao.delUser(user);
    }

    @Override
    public void delUser(int id) {
        userDao.delUser(id);
    }

    @Override
    public boolean exist(String username) {
        User user = userDao.find(username);
        if(user == null){
            return false;
        }
        return true;
    }

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.find(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public String userRegister(Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String password1 = map.get("password1");
        if(!password.equals(password1)){
            return "两次输入的密码不一致!";
        }
        if(!this.exist(username)){
            User user = new User();
            user.setUsername(username);
            user.setEmail(map.get("email"));
            user.setPassword(password);
            userDao.addUser(user);
            return "注册成功！";
        }
        return "用户名已存在！";
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
