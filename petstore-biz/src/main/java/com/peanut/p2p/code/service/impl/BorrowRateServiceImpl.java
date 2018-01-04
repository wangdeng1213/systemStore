package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.BorrowRateDao;
import com.peanut.p2p.code.model.entity.BorrowRate;
import com.peanut.p2p.code.service.BorrowRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("borrowRateService")
public class BorrowRateServiceImpl implements BorrowRateService {

    @Resource
    private BorrowRateDao borrowRateDao;
    @Override
    public List<BorrowRate>queryAll(){return  borrowRateDao.findAll(BorrowRate.class);}
    @Override
    public BorrowRate queryByID(Integer id) {
        return borrowRateDao.findById(BorrowRate.class,id);
    }

    @Override
    public void doSave(BorrowRate BorrowRate) {
        borrowRateDao.save(BorrowRate);
    }

    @Override
    public void doUpdate(BorrowRate BorrowRate) {
        borrowRateDao.update(BorrowRate);
    }

    @Override
    public void doDelete(Integer id) {
        BorrowRate BorrowRate = borrowRateDao.findById(BorrowRate.class,id);
        borrowRateDao.delete(BorrowRate);
    }

    @Override
    public void doUpdate(Integer id) {
        borrowRateDao.update(id);
    }

}
