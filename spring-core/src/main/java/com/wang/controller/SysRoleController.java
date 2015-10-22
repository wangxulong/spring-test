package com.wang.controller;

import com.wang.auth.sys.entity.SysRole;
import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/21.
 */
@Controller
@RequestMapping("/sys/role/")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("index")
    public void index(Model model){
        model.addAttribute("sysRoles", sysRoleService.getAllRoles());
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void add(Long id,Model model){
        SysRole command = new SysRole();
        if(null!=id){
            //command =查询数据库
        }
        model.addAttribute("command",command);
    }
    @RequestMapping(value = "save")
    public String save(String roleName,String roleCode,String roleDesc){
        sysRoleService.addRole(roleName, roleCode,roleDesc,true);
        return "redirect:/sys/role/index";
    }
    @RequestMapping(value = "delete")
    public String delete(Long... id){
        sysRoleService.deleteRole(id);
        return "redirect:/sys/role/index";
    }
}
