package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.BorrowTran;

/**
 * Created by my on 2015/4/11.
 */
public interface BorrowTranService {
    BorrowTran queryByID(Long borrow_tran_id);

    void doSave(BorrowTran borrowTran);

    void doUpdate(BorrowTran borrowTran);

    void doUpdate(Long id);

    void doDelete(Integer borrow_tran_id);
}
