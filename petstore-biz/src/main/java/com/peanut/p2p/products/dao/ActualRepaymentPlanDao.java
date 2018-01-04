package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Update;

/**
 * Created by my on 2014/12/12.
 */
@RepositoryProxy("actualRepaymentPlanDao")
public interface ActualRepaymentPlanDao extends IBaseDao {
    @Update("update ActualRepaymentPlan set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);
}
