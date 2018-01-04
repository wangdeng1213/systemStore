package com.peanut.p2p.code.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.code.model.entity.EnsureType;

import java.util.List;

/**
 * Created by my on 2014/12/12.
 */
@RepositoryProxy("ensureTypeDao")
public interface EnsureTypeDao extends IBaseDao {

    @Update("update EnsureType set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);
    @Query("from EnsureType where act_status='1'")
    public List<EnsureType> findAll();
}
