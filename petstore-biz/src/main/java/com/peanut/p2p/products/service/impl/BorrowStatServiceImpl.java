package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.BorrowStatDao;
import com.peanut.p2p.products.model.entity.BorrowStat;
import com.peanut.p2p.products.service.BorrowStatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/4/11.
 */
@Service("borrowStatService")
public class BorrowStatServiceImpl implements BorrowStatService {
    @Resource
    private BorrowStatDao borrowStatDao;


    @Override
    public BorrowStat queryByID(Integer stat_id) {
        return
                borrowStatDao.findById(BorrowStat.class, stat_id);
    }

    @Override
    public void doSave(BorrowStat borrowStat) {
        borrowStatDao.save(borrowStat);
    }

    @Override
    public void doUpdate(BorrowStat borrowStat) {
        borrowStatDao.update(borrowStat);
    }

    @Override
    public void doDelete(Integer stat_id) {
        borrowStatDao.delete(stat_id);
    }
}
