package com.peanut.p2p.code.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Update;

/**
 * Created by my
 */
@RepositoryProxy("contractDao")
public interface ContractDao extends IBaseDao {

    @Update("update Contract set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);

}
