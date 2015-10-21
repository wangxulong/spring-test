package com.wang.controller;

import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

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
        List<SysUser> sysUsers = sysUserService.getAllSysUser();
        model.addAttribute("sysUsers",sysUsers);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void add(Long id,Model model){
        SysUser command = new SysUser();
        if(null!=id){
            //command =查询数据库
        }
        model.addAttribute("command",command);
    }

    @RequestMapping(value = "save")
    public String save(String userName,String password){
        sysUserService.addUser(userName, password);
        return "redirect:/sys/user/index";
    }
    @RequestMapping(value = "delete")
    public String delete(Long... id){
        sysUserService.deleteSysUser(id);
        return "redirect:/sys/user/index";
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
