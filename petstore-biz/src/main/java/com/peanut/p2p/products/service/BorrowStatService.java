package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.BorrowStat;

/**
 * Created by Administrator on 2015/4/11.
 */
public interface BorrowStatService {
    BorrowStat queryByID(Integer stat_id);

    void doSave(BorrowStat borrowStat);

    void doUpdate(BorrowStat borrowStat);


    void doDelete(Integer stat_id);

}
