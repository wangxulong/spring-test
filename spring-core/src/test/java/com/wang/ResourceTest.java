package com.wang;
import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.entity.SysResource;
import com.wang.auth.sys.service.SysResourceService;
import com.wang.dto.TreeDto;
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
    @Test
    public void  testFolder(){
        sysResourceService.getMyResTree(1l,1l);
    }
}
