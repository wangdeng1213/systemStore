package com.peanut.p2p.code.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.code.model.entity.Pic;
import com.sun.corba.se.impl.interceptors.PICurrent;

import java.util.List;

/**
 * Created by my
 */
@RepositoryProxy("bankDao")
public interface BankDao extends IBaseDao {

    @NativeQuery("SELECT p.id,p.content,p.description  FROM pic p WHERE p.id = ? ")
    @ReturnType(Pic.class)
    Pic getPicById(@Position(1)Integer picId);

    @Update("update Bank set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);
}
