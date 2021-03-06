package com.wang.auth.sys.entity;
// Generated 2016-2-21 21:33:34 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity implements java.io.Serializable {
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
	@Column(name = "nick_name")
	private String nickName;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "email")
	private String email;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "status")
	private Byte status;
	@Transient
	private List<String> userRoleNames;
	@Transient
	private List<SysRole> userRoles;

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public List<String> getUserRoleNames() {
		return userRoleNames;
	}

	public void setUserRoleNames(List<String> userRoleNames) {
		this.userRoleNames = userRoleNames;
	}

	public List<SysRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<SysRole> userRoles) {
		this.userRoles = userRoles;
	}

	public SysUser() {
	}




	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoleIds() {
		return this.roleIds;
	}




	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
