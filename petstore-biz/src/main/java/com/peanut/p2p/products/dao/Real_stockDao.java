package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.p2p.products.model.entity.Real_stock;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("real_stockDao")
public interface Real_stockDao extends IBaseDao {
    @Query("from Real_stock r where r.product_id = :pid")
    Real_stock findByPId(@Param("pid")String id);
}
