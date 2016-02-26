package com.wang.controller;

import com.wang.service.RequireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wxl on 2016/2/26.
 */
@Controller
@RequestMapping("/question/")
public class QuestionController {
    @Resource
    private RequireService requireService;
    @RequestMapping("index")
    @ResponseBody
    public void index(Model model){
      model.addAttribute("questions", requireService.getAllQuestion());
    }
}
