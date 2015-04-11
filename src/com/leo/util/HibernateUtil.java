package com.leo.util;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LT on 2014/12/21.
 */
@Component
public class HibernateUtil {
    private SessionFactory sessionFactory;
    private JdbcTemplate jdbcTemplate;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    private Query createQuery(String hql,Object... values){
        Query query = this.getSession().createQuery(hql);
        for(int i=0;i<values.length;i++){
            query.setParameter(i,values[i]);
        }
        return query;
    }

    private Query createQuery(String hql,Map map){
        Query query = this.getSession().createQuery(hql);
        if(map!=null){
            query.setProperties(map);
        }
        return query;
    }

    public <T> T load(Class<T> entityClass,Serializable id){
        return (T) this.getSession().load(entityClass,id);
    }

    public <T> T get(Class<T> entityClass,Serializable id){
        return (T) this.getSession().get(entityClass,id);
    }

    public <T> List<T> getAll(Class<T> entityClass){
        return this.getSession().createCriteria(entityClass).list();
    }

    public void save(Object obj){
        this.getSession().saveOrUpdate(obj);
    }

    public void remove(Object obj){
        this.getSession().delete(obj);
    }

    public <T> void removeById(Class<T> entityClass,Serializable id){
        this.getSession().delete(this.load(entityClass,id));
    }

    public List find(String hql,Object... values){
        return this.createQuery(hql,values).list();
    }

    public List find(String hql,Map map){
        return this.createQuery(hql,map).list();
    }

    public <T> T findUnique(String hql,Object... values){
        return (T)this.createQuery(hql,values).setMaxResults(1).uniqueResult();
    }

    public <T> T findUnique(String hql,Map map){
        return (T)this.createQuery(hql,map).setMaxResults(1).uniqueResult();
    }

    public <T> Map<String,Object> findByPaging(Class<T> entityClass,int start,int limit ){
        Map<String,Object> result = new HashMap<String, Object>();
        Criteria criteria = this.getSession().createCriteria(entityClass);
        long total = (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List<T> list = criteria.setFirstResult(start).setMaxResults(limit).list();
        result.put("total",total);
        result.put("rows",list);
        return result;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
