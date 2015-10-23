package com.wang.auth.sys.service;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.deploy.util.ArrayUtil;
import com.wang.auth.DbRealm;
import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.dao.SysRoleDao;
import com.wang.auth.sys.dao.SysUserDao;
import com.wang.auth.sys.entity.SysResource;
import com.wang.auth.sys.entity.SysRole;
import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.enumeration.SysResourceType;
import com.wang.dto.ResourceDto;
import com.wang.dto.TreeDto;
import com.wang.util.CommonUtil;
import com.wang.util.PasswordHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.hibernate.annotations.SourceType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by wxl on 2015/10/1.
 */
@Service
@Transactional
public class SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysRoleDao sysRoleDao;


    public SysUser getByName(String name){
        return  sysUserDao.getByUserName(name);
    }

    public SysUser getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        String loginName = (String)subject.getPrincipal();
        return getByName(loginName);
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

        return completeUserRole(sysUserDao.findAll());
    }

    private List<SysUser> completeUserRole(List<SysUser> sysUsers){
        for(SysUser sysUser:sysUsers){
            String roleIds = sysUser.getRoleIds();
            if(!Strings.isNullOrEmpty(roleIds)){
                List<String> roleNames = new ArrayList<String>();
                List<Long> userRoleIds = new ArrayList<Long>();
                for(String roleId:Lists.newArrayList(roleIds.split(","))){
                    userRoleIds.add(Long.parseLong(roleId));
                }
                List<SysRole> sysRoles = sysRoleDao.findByIdIn(userRoleIds);
                for(SysRole sysRole:sysRoles){
                    roleNames.add(sysRole.getRoleName());
                }
                sysUser.setUserRoleNames(roleNames);
                sysUser.setUserRoles(sysRoles);
            }
        }
        return sysUsers;
    }

    public void deleteSysUser(Long... ids){
        for(Long id:ids){
            sysUserDao.delete(id);
        }
    }

    public void addUserRole(Long id,String[] roleIds){
        SysUser user = sysUserDao.findOne(id);
        if(ArrayUtils.isEmpty(roleIds)){
            //空的
            user.setRoleIds(null);
        }else{
            user.setRoleIds(StringUtils.join(roleIds,","));
        }
        sysUserDao.save(user);
        //清除缓存
        RealmSecurityManager securityManager =(RealmSecurityManager)SecurityUtils.getSecurityManager();
        DbRealm dbRealm = (DbRealm) securityManager.getRealms().iterator().next();
        dbRealm.getAuthorizationCache().clear();
    }


    public SysUser findById(Long id){
        return sysUserDao.findOne(id);
    }



    public List<SysRole> getMyRole(Long userId){
        SysUser user= sysUserDao.findOne(userId);
        if(!Strings.isNullOrEmpty(user.getRoleIds())){
            List<Long> roleIds = CommonUtil.convertStringToLongArray(user.getRoleIds());
            return sysRoleDao.findByIdIn(roleIds);
        }
        return null;
    }
}
