package com.peanut.p2p.transaction.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.p2p.transaction.model.entity.Transaction;

import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("transactionDao")
public interface TransactionlDao extends IBaseDao {
    @NativeQuery("SELECT * FROM TRANSACTION tr  WHERE tr.product_id = :pid")
    @ReturnType(Transaction.class)
    List<Transaction> findByPID(@Param("pid") String pid);
}
