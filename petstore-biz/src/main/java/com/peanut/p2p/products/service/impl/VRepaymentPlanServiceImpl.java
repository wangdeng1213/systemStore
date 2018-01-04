package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.VRepaymentPlanDao;
import com.peanut.p2p.products.model.entity.VRepaymentPlan;
import com.peanut.p2p.products.service.VRepaymentPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("vRepaymentPlanService")
public class VRepaymentPlanServiceImpl implements VRepaymentPlanService {

    @Resource
    private VRepaymentPlanDao vRepaymentPlanDao;
    @Override
    public List<VRepaymentPlan>queryAll(){return  vRepaymentPlanDao.findAll(VRepaymentPlan.class);}
    @Override
    public VRepaymentPlan queryByID(Long id) {
        return vRepaymentPlanDao.findById(VRepaymentPlan.class,id);
    }

    @Override
    public void doSave(VRepaymentPlan szVRepaymentPlan) {
        vRepaymentPlanDao.save(szVRepaymentPlan);
    }

    @Override
    public void doUpdate(VRepaymentPlan szVRepaymentPlan) {
        vRepaymentPlanDao.update(szVRepaymentPlan);
    }

    @Override
    public void doDelete(Integer id) {
        VRepaymentPlan VRepaymentPlan = vRepaymentPlanDao.findById(VRepaymentPlan.class,id);
        vRepaymentPlanDao.delete(VRepaymentPlan);
    }

}
