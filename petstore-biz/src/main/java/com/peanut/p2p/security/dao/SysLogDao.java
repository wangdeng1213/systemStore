package com.peanut.p2p.security.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.products.model.entity.Product;

import java.util.List;

/**
 * Created by my
 */
@RepositoryProxy("sysLogDao")
public interface SysLogDao extends IBaseDao {
    @Update("update SysLog set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);

}
