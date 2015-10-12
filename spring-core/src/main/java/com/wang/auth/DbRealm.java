package com.wang.auth;

import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SysUserService;
import com.wang.util.PasswordHelper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
        logger.info("授权认证：" + p.getRealmNames());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        /*ShiroUser shiroUser = (ShiroUser)p.getPrimaryPrincipal();
        User user = userService.getUserByName(shiroUser.loginName);


        for (Role role : user.getRoles()) {
            //基于用户名的角色信息
            info.addRole(role.getName());
            //基于角色的权限信息
            info.setStringPermissions(role.getPermissions());
        }*/
        info.addRole("admin");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        logger.info("authc name:" + token.getUsername());
        logger.info("authc password:" + new String(token.getPassword()));
        SysUser user  = sysUserService.getByName(token.getUsername());
        if (user != null) {
           if(!PasswordHelper.checkMd5Password(token.getUsername(),
                                                new String(token.getPassword()),
                                                user.getSalt(),user.getPassword())){
               return null;
           }
            return new SimpleAuthenticationInfo(user.getUserName(),
                     user.getPassword(),ByteSource.Util.bytes(user.getSalt()), user.getUserName());
        }
        return null;
    }
}
