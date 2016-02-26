package com.wang.service;

import com.wang.dao.RequireDao;
import com.wang.entity.TbRequire;
import com.wang.util.ConstantUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2016/2/26.
 */
@Service
public class RequireService {
    @Resource
    private RequireDao requireDao;
    //获取所有的问答
    public List<TbRequire> getAllQuestion(){
        return requireDao.getAllQuestion(ConstantUtil.questionType);
    }

}
