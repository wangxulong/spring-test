package com.wang.service;

import com.wang.dao.SysUserDataDao;
import com.wang.entity.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/9/29.
 */
@Service
@Transactional
public class SysUserService {
    @Resource
    private SysUserDataDao dao;
    public SysUser getById(){
        return dao.getById(1L);
    }
}
