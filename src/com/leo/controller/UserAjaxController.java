package com.leo.controller;

import com.leo.listener.OnlineUserBoundingListener;
import com.leo.model.User;
import com.leo.service.UserService;
import com.leo.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Controller
@RequestMapping("/userAjax")
@SessionAttributes({"curUserName","curUser"})
public class UserAjaxController {
    private UserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String userRegister(@RequestParam Map<String,String> map){
        return userService.userRegister(map);
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(String username,String password,ModelMap modelMap,HttpSession session){
        User user = userService.userLogin(username,password);
        Map<String,Object> map = new HashMap<String, Object>();
        if(user != null){
            modelMap.addAttribute("curUserName", username);
            modelMap.addAttribute("curUser", user);
            session.setAttribute("onlineUserBindingListener",new OnlineUserBoundingListener(user));
            map.put("success",true);
        }else{
            map.put("success",false);
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
    public List<User> userListData(ModelMap modelMap){
        List<User> list = userService.getAllUser();
        return list;
    }

    @RequestMapping("user_add")
    @ResponseBody
    public Map<String,Object> userAdd(@RequestParam Map<String,String> formData){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String result = userService.addUser(formData);
        if(!result.equals("success")){
            resultMap.put("success",false);
            resultMap.put("msg",result);
        }else{
            resultMap.put("success",true);
        }
        return resultMap;
    }

    @RequestMapping("user_update")
    @ResponseBody
    public Map<String,Object> userUpdate(@RequestParam Map<String,String> formData){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(userService.updateUser(formData) == null){
            resultMap.put("success",false);
            resultMap.put("msg","更新失败");
        }else{
            resultMap.put("success",true);
        }
        return resultMap;
    }

    @RequestMapping("user_delete")
    @ResponseBody
    public Map<String,Object> userDelete(@RequestParam("id") int id){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        userService.delUser(id);
        resultMap.put("success",true);
        return resultMap;
    }

    @RequestMapping("user_profile")
    public String userProfile(String username,ModelMap modelMap){
        if(username == null){
            username = modelMap.get("curUserName").toString();
        }
        User user = userService.findUserByUsername(username);
        modelMap.addAttribute("user",user);
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
        User user = userService.uploadAvatar(username,avatar,path,filename);
        if(user!=null){
            modelMap.put("curUser",user);
            return "success";
        }
        return "fail";
    }

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
