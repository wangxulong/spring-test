package com.wang.dao;

import com.wang.entity.SysUser;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2015/9/30.
 */
@Repository
@Transactional
public class HibernateTemplateDao {
    /*@Resource
    private HibernateTemplate hibernateTemplate;

    public SysUser getById(Long id){
        return hibernateTemplate.get(SysUser.class,id);
    }

    public void addSysUser(SysUser user){
        hibernateTemplate.save(user);
    }

    public List<?> findSysUser(){
        DetachedCriteria criteria = DetachedCriteria.forClass(SysUser.class);
        criteria.add(Restrictions.eq("id",1L));
       return   hibernateTemplate.findByCriteria(criteria);
    }*/
}
