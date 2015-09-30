package com.wang;

import com.wang.dao.SysUserDataDao;
import com.wang.entity.SysUser;
import com.wang.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2015/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class HibernateTest extends AbstractJUnit4SpringContextTests {

  /*  @Resource
    private HibernateTemplateDao hibernateTemplateDao;



    @Test
    public void testOne(){
     *//*  SysUser user = hibernateTemplateDao.getById(1L);
        System.out.println(user.getNickName());*//*
       *//* SysUser user = new SysUser();
        user.setNickName("hibernate");
        user.setName("发布泪");
        hibernateTemplateDao.addSysUser(user);*//*

       List<SysUser> sysUsers = (List<SysUser>  )hibernateTemplateDao.findSysUser();
        for(SysUser user:sysUsers){
            System.out.println(user.getNickName());
        }
    }*/
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void run(){
        System.out.println(sysUserService.getById().getNickName());

    }
}
