package com.wang.dao;

import com.wang.entity.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by wxl on 2015/9/30.
 */
@Repository
public interface SysUserDataDao extends CrudRepository<SysUser,Long> {


    @Query("SELECT a from SysUser a where a.id =?1")
    public SysUser getById(Long id);
}
