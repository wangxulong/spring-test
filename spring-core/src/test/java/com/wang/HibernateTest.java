package com.wang;

import com.wang.auth.sys.entity.SysResource;
import com.wang.auth.sys.enumeration.SysResourceType;
import com.wang.auth.sys.service.SysResourceService;
import com.wang.auth.sys.service.SysRoleService;
import com.wang.auth.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-context.xml")
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
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysResourceService sysResourceService;
    @Test
    public void run(){
      // sysUserService.addUser("admin","admin123");
     //   sysRoleService.addRole("超级管理员","admin","不能删除",true,"*");

       /* SysResource sysResource = new SysResource();
        sysResource.setAvailable(true);
        sysResource.setName("用户管理");
        sysResource.setOrderNum(1);
        sysResource.setParentId(0L);
        sysResource.setResourceCode("user");
        sysResource.setType(SysResourceType.MENU);
        sysResourceService.addResource(sysResource);*/

        sysUserService.login("admin","admin123");
    }


}
