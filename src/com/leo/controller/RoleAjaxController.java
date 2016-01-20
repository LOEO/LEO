package com.leo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.leo.model.SysRole;
import com.leo.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LT on 2015/12/10 0010.
 */
@Controller
@RequestMapping("roleAjax")
public class RoleAjaxController extends BaseController{
    private RoleService roleService;

    @RequestMapping("role_list")
    @ResponseBody
    @JsonView(SysRole.WithoutSysUsers.class)
    public Map<String,Object> roleList(int start,int limit){
        try {
            Map<String,Object> result =  roleService.getPagingRole(start, limit, null, null);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("role_save")
    @ResponseBody
    public Map<String,Object> roleSave(@RequestParam Map<String,Object> formData) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            roleService.save(formData);
            result.put(SUCCESS, true);
        } catch (Exception e) {
            result.put(SUCCESS, false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("role_del")
    @ResponseBody
    public Map<String,Object> roleDel(int id){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            roleService.del(id);
            result.put(SUCCESS, true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put(SUCCESS, false);
        }
        return result;
    }
    @Resource
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
