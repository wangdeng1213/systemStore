package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.BorrowOrderInfo;

/**
 * Created by Administrator on 2015/4/11.
 */
public interface BorrowOrderInfoService {

    BorrowOrderInfo queryByID(Integer borrow_order_id);

    void doSave(BorrowOrderInfo borrowOrderInfo);

    void doUpdate(BorrowOrderInfo borrowOrderInfo);


    void doDelete(Integer borrow_order_id);

    BorrowOrderInfo queryByUserId(Integer userId);

    int doUpdateByUserId(Integer userId);
}
