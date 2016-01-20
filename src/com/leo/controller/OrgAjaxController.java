package com.leo.controller;

import com.leo.model.SysOrg;
import com.leo.service.OrgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Controller
@RequestMapping("/orgAjax")
public class OrgAjaxController extends BaseController{
    private OrgService orgService;

    @RequestMapping("org_add")
    @ResponseBody
    public Map<String,Object> orgAdd(@RequestParam Map<String,String> map){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String pid = map.get("pid");
        String name = map.get("name");
        String descp = map.get("descp");
        SysOrg sysOrg = new SysOrg();
        sysOrg.setName(name);
        sysOrg.setDescp(descp);
        sysOrg.setPid(Integer.parseInt(pid));
        sysOrg.setLeaf("true");
        orgService.addOrg(sysOrg);
        resultMap.put(SUCCESS,true);
        return resultMap;
    }

    @RequestMapping("org_list")
    @ResponseBody
    public Map<String,Object> orgList(@RequestParam("node") int pid){
        Map<String,Object> result = new HashMap<String,Object>();
        List<SysOrg> list = orgService.getOrgList(pid);
        result.put(SUCCESS,true);
        result.put("children",list);
        return result;
    }

    @RequestMapping("org_edit")
    @ResponseBody
    public Map<String,Object> edit(int id,String name,String descp) {
        Map<String, Object> result = new HashMap<String, Object>();
        orgService.updateOrg(id, name, descp);
        result.put(SUCCESS, true);
        return result;
    }

    @RequestMapping("org_delete")
    @ResponseBody
    public Map<String,Object> delete(int id,int pid){
        Map<String,Object> result = new HashMap<String,Object>();
        orgService.deleteOrg(id,pid);
        result.put(SUCCESS,true);
        return result;
    }

    @Resource
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }

}
