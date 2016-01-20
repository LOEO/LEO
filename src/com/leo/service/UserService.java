package com.leo.service;

import com.leo.dao.UserDao;
import com.leo.model.SysUser;
import com.leo.util.Base64_Img;
import com.leo.util.DateUtil;
import com.leo.util.EntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/20.
 */
@Service
@Transactional
public class UserService {
    private UserDao userDao;

    public List<SysUser> getAllUser() {
        return userDao.findAll();
    }

    public Map<String,Object> getPagingUser(int start, int limit,String[] property,Object[] values) {
        return userDao.findByPaging(start,limit,property,values);
    }

    public SysUser findUserById(int id) {
        return userDao.find(id);
    }

    public SysUser findUserByUsername(String username) {
        return userDao.find(username);
    }

    public void addUser(SysUser sysUser){
        userDao.addUser(sysUser);
    }

    public String addUser(Map<String,Object> formData) {
        String username = formData.get("username").toString();
        String passowrd = formData.get("password").toString();
        String passowrd1 = formData.get("password1").toString();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(passowrd != null && !passowrd.equals(passowrd1)){
            return "两次输入的密码不一样！";
        }
        SysUser sysUser = findUserByUsername(username);
        if(sysUser != null){
            return "用户名已存在！";
        }
        //user = formData2User(formData,null);
        sysUser = EntityUtil.buildEntity(SysUser.class, formData);
        userDao.addUser(sysUser);
        return "SUCCESS";
    }

    public void updateUser(SysUser sysUser) {
        userDao.updateUser(sysUser);
    }

    public SysUser updateUser(Map<String,String> map){
        SysUser sysUser = userDao.find(map.get("username"));
        if(!sysUser.getPassword().equals(map.get("password"))){
            return null;
        }
        sysUser = formData2User(map, sysUser);
        sysUser.setEmail(map.get("email"));
        userDao.updateUser(sysUser);
        return sysUser;
    }

    public SysUser uploadAvatar(String username,String avatar,String path,String filename){
        avatar = avatar.replace("data:image/png;base64,","");
        if(Base64_Img.GenerateImage(avatar, path + "\\" + filename)){
            SysUser sysUser = userDao.find(username);
            sysUser.setAvatar(filename);
            userDao.updateUser(sysUser);
            return sysUser;
        }
        return null;
    }

    public void delUser(SysUser sysUser) {
        userDao.delUser(sysUser);
    }

    public void delUser(int id) {
        userDao.delUser(id);
    }

    public boolean exist(String username) {
        SysUser sysUser = userDao.find(username);
        if(sysUser == null){
            return false;
        }
        return true;
    }

    public SysUser userLogin(String username, String password) {
        SysUser sysUser = userDao.find(username);
        if(sysUser !=null && sysUser.getPassword().equals(password)){
            return sysUser;
        }
        return null;
    }

    public String userRegister(Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String password1 = map.get("password1");
        if(!password.equals(password1)){
            return "两次输入的密码不一致!";
        }
        if(!this.exist(username)){
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setEmail(map.get("email"));
            sysUser.setPassword(password);
            userDao.addUser(sysUser);
            return "注册成功！";
        }
        return "用户名已存在！";
    }

    public List<SysUser> findUserByOrgId(int orgId) {
        return userDao.findUserByProperty(new String[]{"orgId"},new Object[]{orgId});
    }

    public Map<String,Object> findUserByOrgId(int start,int limit,int orgId){
        return userDao.findByPaging(start,limit,new String[]{"orgId"},new Object[]{orgId});
    }

    public boolean changePassword(String username,String password,String newPass) {
        SysUser sysUser = findUserByUsername(username);
        if (sysUser != null && sysUser.getPassword().equals(password)) {
            sysUser.setPassword(newPass);
            return true;
        }
        return false;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private SysUser formData2User(Map<String,String> formData,SysUser u){
        String username = formData.get("username");
        String passowrd = formData.get("password");
        String nickname = formData.get("nickname");
        String sex = formData.get("sex");
        String email = formData.get("email");
        String phone = formData.get("phone");
        String birthday = formData.get("birthday");
        SysUser sysUser = u;
        if(sysUser == null){
            sysUser = new SysUser();
        }
        sysUser.setUsername(username);
        sysUser.setSex(sex);
        sysUser.setEmail(email);
        sysUser.setPassword(passowrd);
        sysUser.setBirthday(DateUtil.util2Sql(DateUtil.str2Date(birthday, "yyyy-MM-dd")));
        sysUser.setPhone(phone);
        sysUser.setNickname(nickname);
        sysUser.setAge(0);
        return sysUser;
    }
}
