package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.BoRepaymentPlanDao;
import com.peanut.p2p.products.model.entity.BoRepaymentPlan;
import com.peanut.p2p.products.service.BoRepaymentPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my
 */
@Service("boRepaymentPlanService")
public class BoRepaymentPlanServiceImpl implements BoRepaymentPlanService {

    @Resource
    private BoRepaymentPlanDao repayment_planDao;

    @Override
    public BoRepaymentPlan queryByID(Integer id) {
        return repayment_planDao.findById(BoRepaymentPlan.class,id);
    }

    @Override
    public BoRepaymentPlan queryByUserId(Integer id) {
        return repayment_planDao.findByUserId(id);
    }

    @Override
    public void doSave(BoRepaymentPlan szproduct) {
        repayment_planDao.save(szproduct);
    }

    @Override
    public void doUpdate(BoRepaymentPlan szproduct) {
        repayment_planDao.update(szproduct);
    }

    @Override
    public void doUpdate(Integer id) {
        repayment_planDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        repayment_planDao.delete(id);
    }

}
