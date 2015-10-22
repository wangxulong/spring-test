package com.wang.auth.sys.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wxl on 2015/10/12.
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity{

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "role_ids")
    private String roleIds;
    @Column(name = "locked")
    private Boolean locked;

    @Transient
    private List<String> userRoleNames;
    @Transient
    private List<SysRole> userRoles;


    public List<SysRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<SysRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<String> getUserRoleNames() {
        return userRoleNames;
    }

    public void setUserRoleNames(List<String> userRoleNames) {
        this.userRoleNames = userRoleNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
