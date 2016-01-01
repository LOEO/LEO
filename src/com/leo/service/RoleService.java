package com.leo.service;

import com.leo.dao.RoleDao;
import com.leo.model.Role;
import com.leo.util.EntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by LT on 2015/12/10 0010.15:35
 */
@Service
@Transactional
public class RoleService {
    private RoleDao roleDao;

    public Map<String,Object> getPagingRole(int start, int limit,String[] property,Object[] values) {
        return roleDao.list(start, limit, property, values);
    }

    public void save(Map<String,Object> formData) {
        Role role = EntityUtil.buildEntity(Role.class, formData);
        roleDao.save(role);
    }

    public void del(int id) {
        roleDao.del(id);
    }

    @Resource
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
