package com.wang.controller;

import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/1.
 */
@Controller
@RequestMapping("/sys/user/")
public class SysUserController {
   private Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Resource
    private SysUserService sysUserService;
    @RequestMapping("index")
    public void index(Model model){
        logger.info("this is a test+");
        SysUser user = new SysUser();
        model.addAttribute("sysUser",user);
    }

    @RequestMapping("login")
    public String login(String name,String password){
        try{
            sysUserService.login(name,password);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("登录名或密码错误");
        }

        return "admin/index";
    }
}
