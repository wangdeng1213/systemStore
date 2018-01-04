package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.ActualRepaymentPlanDao;
import com.peanut.p2p.products.model.entity.ActualRepaymentPlan;
import com.peanut.p2p.products.service.ActualRepaymentPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/4/22.
 */
@Service("actualRepaymentPlanService")
public class ActualRepaymentPlanServiceImpl implements ActualRepaymentPlanService {
    @Resource
    private ActualRepaymentPlanDao actualRepaymentPlanDao;

    @Override
    public ActualRepaymentPlan queryByID(Integer id) {
        return actualRepaymentPlanDao.findById(ActualRepaymentPlan.class,id);
    }

    @Override
    public void doSave(ActualRepaymentPlan actualRepaymentPlan) {
        actualRepaymentPlanDao.save(actualRepaymentPlan);
    }

    @Override
    public void doUpdate(ActualRepaymentPlan actualRepaymentPlan) {
        actualRepaymentPlanDao.update(actualRepaymentPlan);
    }

    @Override
    public void doUpdate(Integer id) {
        actualRepaymentPlanDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        ActualRepaymentPlan riskinfo = actualRepaymentPlanDao.findById(ActualRepaymentPlan.class,id);
        actualRepaymentPlanDao.delete(riskinfo);
    }
}
