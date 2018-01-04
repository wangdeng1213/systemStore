package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Position;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.products.model.entity.BorrowTran;

import java.util.List;

/**
 * Created by my on 2015/4/11.
 */
@RepositoryProxy("borrowTranDao")
public interface BorrowTranDao extends IBaseDao {
    @Query("from BorrowTran b where b.deal_status =:dealStatus")
    List<BorrowTran> findProductByStatus(@Param("dealStatus") String statusCode);

    @Update("update BorrowTran set act_status='0' where id= :id")
    public int update(@Param("id") Long id);
//    @Update(nativeUpdate = true, value = "UPDATE  borrow_tran SET deal_status =? WHERE  borrow_tran_id = ?")
//    int updateByDealStatus(@Position(1) String statusCode, @Position(2) Long id);
}
