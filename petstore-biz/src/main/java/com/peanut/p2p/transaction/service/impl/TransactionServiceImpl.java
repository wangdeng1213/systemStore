package com.peanut.p2p.transaction.service.impl;

import com.peanut.p2p.transaction.dao.TransactionlDao;
import com.peanut.p2p.transaction.model.entity.Transaction;
import com.peanut.p2p.transaction.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private TransactionlDao transactionlDao;

    @Override
    public Transaction queryByID(Integer id) {
        return transactionlDao.findById(Transaction.class,id);
    }

    @Override
    public List<Transaction> queryByPID(String pid) {
        return transactionlDao.findByPID(pid);
    }

    @Override
    public void doSave(Transaction szproduct) {
        transactionlDao.save(szproduct);
    }

    @Override
    public void doUpdate(Transaction szproduct) {
        transactionlDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        Transaction tr = queryByID(id);

        transactionlDao.delete(tr);
    }

}
