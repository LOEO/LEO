package com.leo.controller;

import com.leo.model.User;
import com.leo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("curUserName")
public class UserController {
    private UserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String userRegister(@RequestParam Map<String,String> map){
        return userService.userRegister(map);
    }

    @RequestMapping("login")
    public String userLogin(String username,String password,ModelMap modelMap){
        if(userService.userLogin(username,password)){
            modelMap.addAttribute("curUserName",username);
            return "redirect:/index.do";
        }
        modelMap.addAttribute("error","用户名或密码错误！");
        return "login";
    }

    @RequestMapping("user_list")
    public String userList(ModelMap modelMap){
        List<User> list = userService.getAllUser();
        modelMap.addAttribute("userlist",list);
        return "user/user_list";
    }

    @RequestMapping("user_profile")
    public String userProfile(String username,HttpServletRequest req,ModelMap modelMap){
        if(username == null){
            HttpSession session = req.getSession();
            username = session.getAttribute("curUserName").toString();
        }
        User user = userService.findUserByUsername(username);
        modelMap.addAttribute("user",user);
        return "user/user_profile";
    }

    @RequestMapping("user_profile_save")
    public String userProfileSave(@RequestParam Map<String,String> map,ModelMap modelMap,HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = session.getAttribute("curUserName").toString();
        map.put("username",username);
        userService.updateUser(map);
        return "redirect:/user/user_profile.do";
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
