package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.products.model.entity.Riskinfo;

import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("riskinfoDao")
public interface RiskinfoDao extends IBaseDao {
  @Update("update Riskinfo set act_status = 0 where id =:id")
  int update(@Param("id") Long id);

  @Query("from Riskinfo where act_status = 1")
  List<Riskinfo> findAll();
}
