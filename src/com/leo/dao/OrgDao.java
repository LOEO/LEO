package com.leo.dao;

import com.leo.model.Org;
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

    public List<Org> getOrgList() {
        return hibernateUtil.getAll(Org.class);
    }

    public List<Org> getOrgList(int pid) {
        return getOrgList("from Org org where org.pid = ?",pid);
    }

    public List<Org> getOrgList(String hql,Object... values){
        return hibernateUtil.find(hql,values);
    }

    public Org getOrgById(int id) {
        return hibernateUtil.get(Org.class, id);
    }

    public boolean addOrg(Org org) {
        hibernateUtil.save(org);
        return true;
    }

    public boolean updateOrg(Org org) {
        hibernateUtil.save(org);
        return true;
    }

    public boolean deleteOrg(Org org) {
        hibernateUtil.remove(org);
        return true;
    }

    public boolean deleteOrgById(int id) {
        hibernateUtil.removeById(Org.class,id);
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
