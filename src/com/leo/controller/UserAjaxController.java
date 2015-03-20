package com.leo.controller;

import com.leo.listener.OnlineUserBoundingListener;
import com.leo.model.User;
import com.leo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @RequestMapping("user_list")
    @ResponseBody
    public List<User> userListData(ModelMap modelMap){
        List<User> list = userService.getAllUser();
        return list;
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
