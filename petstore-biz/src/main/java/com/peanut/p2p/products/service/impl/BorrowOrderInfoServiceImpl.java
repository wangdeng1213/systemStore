package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.BorrowOrderInfoDao;
import com.peanut.p2p.products.model.entity.BorrowOrderInfo;
import com.peanut.p2p.products.service.BorrowOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/4/11.
 */
@Service("borrowOrderInfoService")
public class BorrowOrderInfoServiceImpl implements BorrowOrderInfoService {

    @Resource
    private BorrowOrderInfoDao borrowOrderInfoDao;


    @Override
    public BorrowOrderInfo queryByID(Integer borrow_order_id) {
        return
                borrowOrderInfoDao.findById(BorrowOrderInfo.class, borrow_order_id);
    }

    @Override
    public void doSave(BorrowOrderInfo borrowOrderInfo) {
        borrowOrderInfoDao.save(borrowOrderInfo);
    }

    @Override
    public void doUpdate(BorrowOrderInfo borrowOrderInfo) {
        borrowOrderInfoDao.update(borrowOrderInfo);
    }

    @Override
    public void doDelete(Integer borrow_order_id) {
        borrowOrderInfoDao.delete(borrow_order_id);
    }

    @Override
    public BorrowOrderInfo queryByUserId(Integer userId) {
        return borrowOrderInfoDao.findByUserId(userId);
    }

    @Override
    public int doUpdateByUserId(Integer userId) {
        return borrowOrderInfoDao.updateByUserId(userId);
    }
}
