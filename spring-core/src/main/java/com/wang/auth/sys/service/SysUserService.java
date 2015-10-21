package com.wang.auth.sys.service;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.wang.auth.sys.dao.SysUserDao;
import com.wang.auth.sys.entity.SysUser;
import com.wang.util.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void addUser(String userName,String password){
        SysUser user = PasswordHelper.md5Password(userName,password);
        sysUserDao.save(user);
    }

    public List<SysUser> getAllSysUser(){
        return sysUserDao.findAll();
    }

    public void deleteSysUser(Long... ids){
        for(Long id:ids){
            sysUserDao.delete(id);
        }
    }
}
