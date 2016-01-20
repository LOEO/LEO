package com.leo.dao;

import com.leo.model.SysRole;
import com.leo.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by LT on 2015/12/10 0010.
 */
@Repository
public class RoleDao {
    private HibernateUtil hibernateUtil;

    public Map<String,Object> list(int start, int limit,String[] property,Object[] values) {
        return hibernateUtil.findByPaging(SysRole.class, start, limit, property, values);
    }

    public void save(SysRole sysRole){
        hibernateUtil.save(sysRole);
    }

    public void del(int id){
        hibernateUtil.removeById(SysRole.class,id);
    }

    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
