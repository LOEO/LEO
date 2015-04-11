package com.leo.service.serviceimp;

import com.leo.dao.UserDao;
import com.leo.model.User;
import com.leo.service.UserService;
import com.leo.util.Base64_Img;
import com.leo.util.DateUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
    public Map<String,Object> getPagingUser(int start, int limit) {
        return userDao.findByPaging(start,limit);
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
    public void addUser(User user){
        userDao.addUser(user);
    }

    public String addUser(Map<String,String> formData) {
        String username = formData.get("username");
        String passowrd = formData.get("password");
        String passowrd1 = formData.get("password1");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(passowrd != null && !passowrd.equals(passowrd1)){
            return "两次输入的密码不一样！";
        }
        User user = findUserByUsername(username);
        if(user != null){
            return "用户名已存在！";
        }
        user = formData2User(formData,null);
        userDao.addUser(user);
        return "success";
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User updateUser(Map<String,String> map){
        User user = userDao.find(map.get("username"));
        if(!user.getPassword().equals(map.get("password"))){
            return null;
        }
        user = formData2User(map,user);
        user.setEmail(map.get("email"));
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

    private User formData2User(Map<String,String> formData,User u){
        String username = formData.get("username");
        String passowrd = formData.get("password");
        String nickname = formData.get("nickname");
        String sex = formData.get("sex");
        String email = formData.get("email");
        String phone = formData.get("phone");
        String birthday = formData.get("birthday");
        User user = u;
        if(user == null){
            user = new User();
        }
        user.setUsername(username);
        user.setSex(sex);
        user.setEmail(email);
        user.setPassword(passowrd);
        user.setBirthday(DateUtil.util2Sql(DateUtil.str2Date(birthday, "yyyy-MM-dd")));
        user.setPhone(phone);
        user.setNickname(nickname);
        user.setAge(0);
        return user;
    }
}
