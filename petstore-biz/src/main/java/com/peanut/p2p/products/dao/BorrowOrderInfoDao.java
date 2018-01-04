package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.products.model.entity.BorrowOrderInfo;
import com.peanut.p2p.transaction.model.entity.Order_info;

/**
 * Created by my on 2015/4/11.
 */
@RepositoryProxy("borrowOrderInfoDao")
public interface BorrowOrderInfoDao extends IBaseDao {
    @Update("update BorrowOrderInfo set loanorder_status = '2' where borrow_order_id =:orderId  and loanorder_status='1'")
    int updateById(@Param("orderId") Integer orderId);
    @Query("from BorrowOrderInfo  where loanorder_status='1' and user_id = :userId")
    BorrowOrderInfo findByUser(@Param("userId") Integer userId);

    @NativeQuery("SELECT * FROM borrow_order_info bo WHERE bo.loanorder_status='2' AND user_id = :userId")
    @ReturnType(Order_info.class)
    BorrowOrderInfo findByUserId(@Param("userId") Integer userId);
    @Update("update BorrowOrderInfo set loanorder_status = '3' where loanorder_status = '2' and user_id = :userId")
    int updateByUserId(@Param("userId") Integer userId);
}

