package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.products.model.entity.BoRepaymentPlan;

/**
 * Created by my
 */
@RepositoryProxy("boRepaymentPlanDao")
public interface BoRepaymentPlanDao extends IBaseDao {
      @Query("from BoRepaymentPlan where user_id=:id and act_status = 1")
      BoRepaymentPlan findByUserId(@Param("id")Integer id );
      @Update("update BoRepaymentPlan set act_status =0 where id = :id ")
      int update(@Param("id") Integer id);
}
