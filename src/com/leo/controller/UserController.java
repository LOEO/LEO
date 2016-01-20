package com.leo.controller;

import com.leo.model.SysUser;
import com.leo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({"curUserName","curUser"})
public class UserController extends BaseController{
    private UserService userService;


    @RequestMapping("user_list")
    public String userList(ModelMap modelMap){
        return "user/user_list";
    }

    @RequestMapping("user_view")
    public String userView(ModelMap modelMap){
        return "user/user_view";
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
