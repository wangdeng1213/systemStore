package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.BoActualRepaymentDao;
import com.peanut.p2p.products.model.entity.BoActualRepayment;
import com.peanut.p2p.products.service.BoActualRepaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/4/11.
 */
@Service("boActualRepaymentService")
public class BoActualRepaymentServiceImpl implements BoActualRepaymentService {
    @Resource
    private BoActualRepaymentDao actualRepaymentDao;


    @Override
    public BoActualRepayment queryByID(Integer actual_repayment_id) {
        return
                actualRepaymentDao.findById(BoActualRepayment.class, actual_repayment_id);
    }

    @Override
    public void doSave(BoActualRepayment actualRepayment) {
        actualRepaymentDao.save(actualRepayment);
    }

    @Override
    public void doUpdate(BoActualRepayment actualRepayment) {
        actualRepaymentDao.update(actualRepayment);
    }

    @Override
    public void doDelete(Integer actual_repayment_id) {
        actualRepaymentDao.delete(actual_repayment_id);
    }
}
