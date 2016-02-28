package com.wang;
import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.entity.SysResource;
import com.wang.auth.sys.service.SysResourceService;
import com.wang.dto.QuestionDto;
import com.wang.dto.TreeDto;
import com.wang.entity.TbRequire;
import com.wang.service.RequireService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2015/10/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-context.xml")
public class ResourceTest {
    @Resource
    private SysResourceService sysResourceService;
    @Resource
    private SysResourceDao sysResourceDao;
    @Resource
    private RequireService requireService;
    @Test
    public void  testFolder(){
      requireService.getQuestionById(2L);
    }
}
