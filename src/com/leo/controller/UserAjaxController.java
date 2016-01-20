
package com.leo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.leo.listener.OnlineUserBoundingListener;
import com.leo.model.SysUser;
import com.leo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Controller
@RequestMapping("/userAjax")
@SessionAttributes({"curUserName","curUser"})
public class UserAjaxController extends BaseController{
    private UserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String userRegister(@RequestParam Map<String,String> map){
        return userService.userRegister(map);
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(String username,String password,ModelMap modelMap,HttpSession session){
        SysUser sysUser = userService.userLogin(username,password);
        Map<String,Object> map = new HashMap<String, Object>();
        if(sysUser != null){
            modelMap.addAttribute("curUserName", username);
            session.setAttribute("onlineUserBindingListener",new OnlineUserBoundingListener(sysUser));
/*            if (!Leo.USERS.containsKey(user.getUsername())) {
                Leo.USERS.put(user.getUsername(), user);
                Leo.USER_COUNT++;

            }else{
                map.put("success",false);
                map.put("msg","该用户已经登陆!");
            }*/
            map.put(SUCCESS,true);
        }else{
            map.put(SUCCESS,false);
            map.put("msg","用户名或密码错误!");
        }
        return map;
    }

    @RequestMapping("check_user_exist")
    @ResponseBody
    public Map<String,Object> checkUserExist(String username){
        Map<String,Object> map = new HashMap<String, Object>();
        if(userService.exist(username)){
            map.put("exist",true);
        }else {
            map.put("exist",false);
        }
        return map;
    }

    @RequestMapping("user_list")
    @ResponseBody
    @JsonView(SysUser.WithoutPasswordView.class)
    public Map<String,Object> userList(int start,int limit){
        return userService.getPagingUser(start, limit,null,null);
    }

    @RequestMapping("user_add")
    @ResponseBody
    public Map<String,Object> userAdd(@RequestParam Map<String,Object> formData){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String result = userService.addUser(formData);
        if(!result.equals(SUCCESS)){
            resultMap.put(SUCCESS,false);
            resultMap.put("msg",result);
        }else{
            resultMap.put(SUCCESS,true);
        }
        return resultMap;
    }

    @RequestMapping("user_update")
    @ResponseBody
    public Map<String,Object> userUpdate(@RequestParam Map<String,String> formData){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(userService.updateUser(formData) == null){
            resultMap.put(SUCCESS,false);
            resultMap.put("msg","更新失败，密码有误！");
        }else{
            resultMap.put(SUCCESS,true);
        }
        return resultMap;
    }

    @RequestMapping("user_delete")
    @ResponseBody
    public Map<String,Object> userDelete(@RequestParam("id") int id){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        userService.delUser(id);
        resultMap.put(SUCCESS,true);
        return resultMap;
    }

    @RequestMapping("user_profile")
    public String userProfile(String username,ModelMap modelMap){
        if(username == null){
            username = modelMap.get("curUserName").toString();
        }
        SysUser sysUser = userService.findUserByUsername(username);
        modelMap.addAttribute("user", sysUser);
        return "user/user_profile";
    }

    @RequestMapping("user_profile_save")
    public String userProfileSave(@RequestParam Map<String,String> map,ModelMap modelMap){
        String username = modelMap.get("curUserName").toString();
        map.put("username",username);
        userService.updateUser(map);
        return "redirect:/user/user_profile.do";
    }

    @RequestMapping("user_profile_uploadAvatar")
    @ResponseBody
    public String uploadAvatar(String avatar,HttpServletRequest req,ModelMap modelMap){
        String username = modelMap.get("curUserName").toString();
        String filename = System.currentTimeMillis()+".jpg";
        String path = req.getServletContext().getRealPath("/upload");
        SysUser sysUser = userService.uploadAvatar(username,avatar,path,filename);
        if(sysUser !=null){
            modelMap.put("curUser", sysUser);
            return SUCCESS;
        }
        return "fail";
    }

    @RequestMapping("change_password")
    @ResponseBody
    public Map<String,Object> changePassword(String username,String password,String newPassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (userService.changePassword(username, password,newPassword)) {
                map.put(SUCCESS, true);
                map.put("msg", "修改密码成功！");
            }else{
                map.put(SUCCESS, false);
                map.put("msg", "修改密码失败，原密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(SUCCESS, false);
            map.put("msg", "修改密码失败!");
        }
        return map;
    };

    @RequestMapping
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
