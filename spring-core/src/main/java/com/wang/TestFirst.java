package com.wang;

import com.wang.service.SysUserService;
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
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestFirst extends AbstractJUnit4SpringContextTests {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void testOne(){
        sysUserService.test();
    }
}
