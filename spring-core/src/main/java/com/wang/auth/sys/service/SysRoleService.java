package com.wang.auth.sys.service;

import com.wang.auth.sys.dao.SysRoleDao;
import com.wang.auth.sys.entity.SysRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/12.
 */
@Service
@Transactional
public class SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;


    public void addRole(String roleName,String roleCode,String roleDesc,boolean available,String resourceIds){
        SysRole role = new SysRole();
        role.setAvailable(available);
        role.setRoleName(roleName);
        role.setResourceIds(resourceIds);
        role.setRoleCode(roleCode);
        role.setRoleDesc(roleDesc);
        sysRoleDao.save(role);

    }

}
