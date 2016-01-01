package com.leo.dao;

import com.leo.model.Role;
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
        return hibernateUtil.findByPaging(Role.class, start, limit, property, values);
    }

    public void save(Role role){
        hibernateUtil.save(role);
    }

    public void del(int id){
        hibernateUtil.removeById(Role.class,id);
    }

    @Resource
    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
