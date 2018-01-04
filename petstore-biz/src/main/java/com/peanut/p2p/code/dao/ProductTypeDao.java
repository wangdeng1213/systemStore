package com.peanut.p2p.code.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Update;

/**
 * Created by my
 */
@RepositoryProxy("productTypeDao")
public interface ProductTypeDao extends IBaseDao {

    @Update("update ProductType set status='0' where id= :id")
    public int update(@Param("id") Integer id);

}
