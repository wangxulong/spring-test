package com.wang.dao;

import com.wang.auth.sys.dao.BaseDao;
import com.wang.entity.TbComment;
import com.wang.entity.TbRequire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wxl on 2016/2/26.
 */
@Repository
public interface CommentDao extends BaseDao<TbComment,Long>{
}
