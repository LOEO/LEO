package com.leo.dao;

import com.leo.model.SysOrg;
import com.leo.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LT on 2015-04-20.
 */
@Repository
public class OrgDao {
    HibernateUtil hibernateUtil;

    public List<SysOrg> getOrgList() {
        return hibernateUtil.getAll(SysOrg.class);
    }

    public List<SysOrg> getOrgList(int pid) {
        return getOrgList("from SysOrg org where org.pid = ?",pid);
    }

    public List<SysOrg> getOrgList(String hql,Object... values){
        return hibernateUtil.find(hql,values);
    }

    public SysOrg getOrgById(int id) {
        return hibernateUtil.get(SysOrg.class, id);
    }

    public boolean addOrg(SysOrg sysOrg) {
        hibernateUtil.save(sysOrg);
        return true;
    }

    public boolean updateOrg(SysOrg sysOrg) {
        hibernateUtil.save(sysOrg);
        return true;
    }

    public boolean deleteOrg(SysOrg sysOrg) {
        hibernateUtil.remove(sysOrg);
        return true;
    }

    public boolean deleteOrgById(int id) {
        hibernateUtil.removeById(SysOrg.class,id);
        return true;
    }

    public HibernateUtil getHibernateUtil() {
        return hibernateUtil;
    }

    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
