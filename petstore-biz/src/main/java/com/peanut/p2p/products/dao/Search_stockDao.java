package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.p2p.products.model.entity.Search_stock;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("search_stockDao")
public interface Search_stockDao extends IBaseDao {
    @Query("from Search_stock s where s.product_id = :pid")
    Search_stock findByPId(@Param("pid")String id);
}
