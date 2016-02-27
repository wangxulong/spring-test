package com.wang.controller;

import com.alibaba.fastjson.JSON;
import com.wang.dto.QuestionDto;
import com.wang.dto.ResultMessage;
import com.wang.service.RequireService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2016/2/26.
 */
@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    @Resource
    private RequireService requireService;
    //获取热点问答
    @RequestMapping("hotQuestion")
    @ResponseBody
    public ResultMessage getAjaxHot(){
        List<QuestionDto> hots = requireService.getHotQuestion();
        return new ResultMessage(ResultMessage.SUCCESS,"请求成功",hots);
    }
    //通过ID获取问答
    @RequestMapping("question")
    @ResponseBody
    public ResultMessage getQuestionById(Long id){
        QuestionDto questionDto = requireService.getQuestionById(id);
        return new ResultMessage(ResultMessage.SUCCESS,"请求成功",questionDto);
    }
}
