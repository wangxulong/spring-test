package com.wang.auth.sys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by wxl on 2015/10/1.
 */
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T,ID>  {
}
