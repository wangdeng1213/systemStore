package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("e_attributeDao")
public interface Repayment_planDao extends IBaseDao {
    @Update("update Repayment_plan set act_status = 0 where repayment_plan_id=:id")
    int update(@Param("id") Integer id);
}
