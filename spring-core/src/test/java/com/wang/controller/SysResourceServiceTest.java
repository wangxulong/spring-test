package com.wang.controller;

import javax.annotation.Resource;

import org.junit.Test;

import com.wang.auth.sys.service.SysResourceService;
import com.wang.commpent.JunitBaseUtil;

/**
 * 
 * @Title: SysResourceControllerTest.java
 * @Package: com.wang.controller
 * @Description:系统资源控制层测试
 * @author: sunwei
 * @date: 2015年10月26日 下午12:36:01
 * @version: V1.0
 */
public class SysResourceServiceTest extends JunitBaseUtil{
	@Resource(name="sysResourceService")
	private SysResourceService sysResourceService;
	/**
	 * 
	 * @Title: getResTreeByParentIdAndUserId
	 * @Description:根据父类节点和用户编号查询节点数据
	 * @author:sunwei
	 * @createTime:2015年10月26日下午12:42:27
	 */
	@Test
	public void getResTreeByParentIdAndUserId(){
		sysResourceService.getMyResTree(100L, 100L);
	}
	/**
	 * 
	 * @Title: iocClass
	 * @Description:sysResourceService && sysUserService互相注入 
	 * @author:sunwei
	 * @createTime:2015年10月26日下午1:06:44
	 */
	@Test
	public void iocClass(){
		sysResourceService.iocSysUserService();	
	}
}
