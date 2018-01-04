package com.peanut.p2p.user.dao;


import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Update;

/**
 * Created by my on 2015/2/5.
 */
@RepositoryProxy("internetUserDao")
public interface InternetUserDao extends IBaseDao {
    @Update("update InternetUser set status='0' where id= :id")
    public int doUpdate(@Param("id") Integer id);
}
