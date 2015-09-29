package com.wang;

import com.wang.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestOne extends AbstractJUnit4SpringContextTests {
    Logger testLogger = LoggerFactory.getLogger(SysUserService.class);
    @Resource
    private SysUserService sysUserService;

    @Test
    public void testOne(){
        sysUserService.test();
        testLogger.info("wangxulong");
    }

}
