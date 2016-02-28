package com.wang;

import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.service.SysResourceService;
import com.wang.entity.TbComment;
import com.wang.service.CommentService;
import com.wang.service.RequireService;
import com.wang.util.ConstantUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wxl on 2015/10/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-context.xml")
public class CommentTest {
    @Resource
    private CommentService commentService;
    @Test
    public void  addComment(){
        TbComment comment = new TbComment();
        comment.setUserId(7L);
        comment.setContentId(2L);
        comment.setContentType(ConstantUtil.questionType);
        comment.setContent("不想学习");
        commentService.addOrUpdateComment(comment);

    }
    @Test
    public void  getCommentByContentId(){
       commentService.getAllQuestionComment(2L);


    }
}
