package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.VBorrowRepaymentPlanDao;
import com.peanut.p2p.products.model.entity.VBorrowRepaymentPlan;
import com.peanut.p2p.products.service.VBorrowRepaymentPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("vBorrowRepaymentPlanService")
public class VBorrowRepaymentPlanServiceImpl implements VBorrowRepaymentPlanService {

    @Resource
    private VBorrowRepaymentPlanDao vBorrowRepaymentPlanDao;
    @Override
    public List<VBorrowRepaymentPlan>queryAll(){return
            vBorrowRepaymentPlanDao.findAll(VBorrowRepaymentPlan.class);
    }
    @Override
    public VBorrowRepaymentPlan queryByID(Long id) {
        return vBorrowRepaymentPlanDao.findById(VBorrowRepaymentPlan.class,id);
    }

    @Override
    public void doSave(VBorrowRepaymentPlan szVBorrowRepaymentPlan) {
        vBorrowRepaymentPlanDao.save(szVBorrowRepaymentPlan);
    }

    @Override
    public void doUpdate(VBorrowRepaymentPlan szVBorrowRepaymentPlan) {
        vBorrowRepaymentPlanDao.update(szVBorrowRepaymentPlan);
    }

    @Override
    public void doDelete(Integer id) {
        VBorrowRepaymentPlan VBorrowRepaymentPlan = vBorrowRepaymentPlanDao.findById(VBorrowRepaymentPlan.class,id);
        vBorrowRepaymentPlanDao.delete(VBorrowRepaymentPlan);
    }

}
