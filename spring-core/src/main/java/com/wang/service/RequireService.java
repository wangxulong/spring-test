package com.wang.service;

import com.wang.auth.sys.entity.SysUser;
import com.wang.auth.sys.service.SecurityService;
import com.wang.auth.sys.service.SysUserService;
import com.wang.dao.RequireDao;
import com.wang.dto.QuestionDto;
import com.wang.entity.TbRequire;
import com.wang.util.ConstantUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by wxl on 2016/2/26.
 */
@Service
@Transactional
public class RequireService {
    @Resource
    private RequireDao requireDao;
    @Resource
    private SecurityService securityService;
    @Resource
    private EntityManagerFactory managerFactory;
    private Long hot;

    //获取所有的问答
    public List<QuestionDto> getAllQuestion(){
       EntityManager entityManager = managerFactory.createEntityManager();
        String sql = "SELECT r.id as id, r.user_id as userId,r.title,r.description,r.good,r.bad,r.type,r.create_time as createTime," +
                "r.begin_time as beginTime,r.end_time as endTime,r.category_id as categoryId,r.tag_id as tagId,r.status " +
                ",u.user_name as userName from tb_require r LEFT JOIN sys_user u on u.id = r.user_id where r.type="+ConstantUtil.questionType+ " " +
                " and r.status <>"+ConstantUtil.delete_status +" order by r.status desc ,r.create_time DESC ";
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
        List rows = query.getResultList();
        entityManager.close();
        return rows;
    }

    public void addQuestion(TbRequire question) {
        if(null!=question.getId()){
            question =updateQuestion(question);
        }
        SysUser user = securityService.getLoginUser();
        question.setUserId(user.getId());
        question.setCreateTime(new Date());
        question.setType(ConstantUtil.questionType);
        question.setStatus(ConstantUtil.normal_status);
        requireDao.save(question);
    }

    private TbRequire updateQuestion(TbRequire question){
        TbRequire db = requireDao.getOne(question.getId());
        db.setTitle(question.getTitle());
        db.setDescription(question.getDescription());
        return db;
    }

    public TbRequire findById(Long id) {
        return requireDao.findOne(id);
    }

    public void removeQuestion(Long id) {
       TbRequire require = requireDao.findOne(id);
       if(null!=require) {
           require.setStatus(ConstantUtil.delete_status);
           requireDao.save(require);
       }
    }



    public void upToHot(Long id) {
        TbRequire require = requireDao.findOne(id);
        if(null!=require) {
            require.setStatus(ConstantUtil.hot_status);
            requireDao.save(require);
        }
    }

    //异步获取热点问题
    public List<QuestionDto> getHotQuestion(){
        EntityManager entityManager = managerFactory.createEntityManager();
        String sql = "SELECT  r.id as id, r.user_id as userId,r.title,r.description,r.good,r.bad,r.type,r.create_time as createTime," +
                "r.begin_time as beginTime,r.end_time as endTime,r.category_id as categoryId,r.tag_id as tagId,r.status " +
                ",u.user_name as userName from tb_require r LEFT JOIN sys_user u on u.id = r.user_id where r.type="+ConstantUtil.questionType+ " " +
                " and r.status ="+ConstantUtil.hot_status +" order by r.status desc ,r.create_time DESC limit 3 ";
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
        List rows = query.getResultList();
        entityManager.close();
        return rows;
    }

    //通过ID获取问答信息
    public QuestionDto getQuestionById(Long id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        String sql = "SELECT  r.id as id, r.user_id as userId,r.title,r.description,r.good,r.bad,r.type,r.create_time as createTime," +
                "r.begin_time as beginTime,r.end_time as endTime,r.category_id as categoryId,r.tag_id as tagId,r.status " +
                ",u.user_name as userName from tb_require r LEFT JOIN sys_user u on u.id = r.user_id where r.id="+id+ " " +
                " and r.status <>"+ConstantUtil.delete_status ;
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(QuestionDto.class));

        List rows = query.getResultList();

        entityManager.close();
        if(!rows.isEmpty()) return (QuestionDto) rows.get(0);
        return null;
    }
}
