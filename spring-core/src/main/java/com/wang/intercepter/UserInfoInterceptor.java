package com.wang.intercepter;

import com.wang.auth.sys.service.SecurityService;
import com.wang.auth.sys.util.CurrentThreadUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wxl on 2015/10/20.
 */
public class UserInfoInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private SecurityService securityService;

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("loginUser",securityService.getLoginUser());
        System.out.println("当前登录用户："+securityService.getLoginUser().getUserName());
    }

}
