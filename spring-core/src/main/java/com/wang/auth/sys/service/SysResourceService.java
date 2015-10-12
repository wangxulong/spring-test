package com.wang.auth.sys.service;

import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.entity.SysResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/12.
 */
@Service
@Transactional
public class SysResourceService {
    @Resource
    private SysResourceDao sysResourceDao;

    public void addResource(SysResource sysResource){
        sysResourceDao.save(sysResource);
    }
}
