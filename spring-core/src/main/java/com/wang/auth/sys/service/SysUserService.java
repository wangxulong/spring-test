package com.wang.auth.sys.service;

import com.wang.auth.sys.dao.SysUserDao;
import com.wang.auth.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/1.
 */
@Service
@Transactional
public class SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    public SysUser getByName(String name){
        return sysUserDao.getByUserName(name);
    }

    public void login(String name,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        SecurityUtils.getSubject().login(token);
    }
}
