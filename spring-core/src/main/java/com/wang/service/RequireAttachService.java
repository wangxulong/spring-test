package com.wang.service;

import com.wang.dao.CategoryDao;
import com.wang.dao.RequireAttachDao;
import com.wang.entity.TbCategory;
import com.wang.entity.TbRequireAttach;
import com.wang.util.ConstantUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wxl on 2016/3/1.
 */
@Service
@Transactional
public class RequireAttachService {
    @Resource
    private RequireAttachDao requireAttachDao;

    public void addAttach(TbRequireAttach attach){
        //默认为0
        attach.setType((byte)0);
        requireAttachDao.save(attach);
    }
}

