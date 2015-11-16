package com.wang.commpent;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @Title: JunitBaseUtil.java
 * @Package: com.wang.commpent
 * @Description: 测试基类
 * @author: sunwei
 * @date: 2015年10月26日 上午11:42:55
 * @version: V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-context.xml"}
)
//@Transactional(transactionManager="transactionManager")
public class JunitBaseUtil {
	protected static ApplicationContext context;
	/**
	 * 
	 * @Title: getApp
	 * @Description:初始化上下文
	 * @author:sunwei
	 * @createTime:2015年10月26日下午12:34:53
	 * @param args 各文件配置数组
	 * @return spring上下文
	 */
	public static ApplicationContext getApp(String[] args) {
		if (null == context) {
			context = new ClassPathXmlApplicationContext(args);
		}
		return context;
	}
	/**
	 * 
	 * @Title: beforeTask
	 * @Description:单元测试前置任务
	 * @author:sunwei
	 * @createTime:2015年10月26日下午12:35:35
	 */
	@SuppressWarnings("static-access")
	@Before
	public void beforeTask() {
		String[] args = { "classpath:config/spring-context.xml"};
		context=this.getApp(args);
	}
}
