package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.p2p.products.model.entity.BoRepaymentDetail;

import java.util.List;

/**
 * Created by my
 */
@RepositoryProxy("boRepaymentDetailDao")
public interface BoRepaymentDetailDao extends IBaseDao {
   @Query("from BoRepaymentDetail where product_id = :productId  and term = :term ")
   BoRepaymentDetail findByIdAndTerm(@Param("productId") Integer productId,@Param("term") Integer term);

   @Query("from BoRepaymentDetail where product_id = :id")
   List<BoRepaymentDetail> findByProductId(@Param("id") Integer id);
}
