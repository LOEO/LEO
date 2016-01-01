package com.leo.service;

import com.leo.dao.OrgDao;
import com.leo.model.Org;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LT on 2015-04-20.
 */
@Service
@Transactional
public class OrgService {
    private OrgDao orgDao;

    public List<Org> getOrgList(int pid) {
        return orgDao.getOrgList(pid);
    }

    public boolean addOrg(Org org) {
        if(org.getPid()!=0){
            Org parent = orgDao.getOrgById(org.getPid());
            parent.setLeaf("false");
        }
        return orgDao.addOrg(org);
    }

    public boolean updateOrg(int id,String name,String descp) {
        Org org = orgDao.getOrgById(id);
        org.setName(name);
        org.setDescp(descp);
        return orgDao.updateOrg(org);
    }

    public boolean deleteOrg(int id,int pid) {
        orgDao.deleteOrgById(id);
        List<Org> orgs = orgDao.getOrgList(pid);
        if(orgs == null || orgs.size() == 0){
            Org org = orgDao.getOrgById(pid);
            org.setLeaf("true");
        }
        return true;
    }

    public OrgDao getOrgDao() {
        return orgDao;
    }

    @Resource
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }
}
