package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.products.model.entity.Transfer;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("TransferDao")
public interface TransferDao extends IBaseDao {

    @Query(" from Transfer t  where product_id = :pid")
    Transfer getByPid( @Param("pid") String pid);
    @Update("update Transfer set endTime = :endTime where productId = :id ")
    public int update(@Param("id") String id,@Param("endTime") Timestamp endTime);
}

