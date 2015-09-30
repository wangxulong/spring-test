package com.wang;

import com.wang.dao.SysUserDao;
import com.wang.entity.SysUser;
import com.wang.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class TestFirst extends AbstractJUnit4SpringContextTests {


    @Resource
    private SysUserDao sysUserDao;


    @Test
    public void testOne(){
        //System.out.println(sysUserDao.getSysUserCount());
      //  sysUserDao.addSysUser("王12旭龙");
       // sysUserDao.deleteById(4L);

        List<SysUser> allUsers = sysUserDao.getAllSysUser();
        for(SysUser user:allUsers){
            System.out.println("id="+user.getId()+";nickName="+user.getNickName());
        }
    }
}
