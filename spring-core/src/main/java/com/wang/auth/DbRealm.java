package com.wang.auth;

import com.google.common.base.Strings;
import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SysUserService;
import com.wang.auth.sys.util.CurrentThreadUtil;
import com.wang.util.PasswordHelper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.omg.CORBA.Current;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/1.
 */
public class DbRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(DbRealm.class);
    @Resource
    private SysUserService sysUserService;

    @Resource
    private CurrentThreadUtil currentThreadUtil;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
        SysUser user = currentThreadUtil.getCurrentUser();
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//          for (Role role : user.getRoles()) {
//              //基于Role的权限信息
//              info.addRole(role.getName());
//          }
//          info.addStringPermissions(user.getPermissions());
            info.addRole("admin");
            return info;
        } else {
            return null;
        }


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        SysUser user  = sysUserService.getByName(token.getUsername());
        if (user != null) {
           SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(user.getUserName(),
                    user.getPassword(),ByteSource.Util.bytes(user.getUserName()+user.getSalt()), user.getUserName());

            return info;
        }
        return null;
    }
}
